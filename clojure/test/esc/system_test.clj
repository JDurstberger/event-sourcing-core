(ns esc.system-test
  (:require [clojure.test :refer :all]
            [esc.events :as events]
            [esc.system :as system]
            [esc.users :as users]))

(deftest no-users-exist-by-default
  (let [system (system/new)]
    (testing "users are empty"
      (is (empty? (users/all system))))))

(deftest no-events-exist-by-default
  (let [system (system/new)]
    (testing "events are empty"
      (is (empty? (events/all system))))))

(deftest returns-user-upon-creation
  (let [system (system/new)
        username "Jane"

        user (users/create system username)]

    (testing "user"
      (is (= username (:username user)))
      (is (uuid? (:id user))))))

(deftest creates-events-upon-creation
  (let [system (system/new)
        username "Jane"]
    (users/create system username)

    (testing "user-created event"
      (let [events (events/all system)
            event (first events)]
        (is (= 1 (count events)))

        (is (uuid? (:id event)))
        (is (= :user-created (:type event)))
        (is (= username (get-in event [:payload :username])))))))

(deftest all-users-contains-created-user
  (let [system (system/new)
        username "Jane"

        _ (users/create system username)

        users (users/all system)]

    (is (not-empty users))))

(deftest returns-user-by-id
  (let [system (system/new)
        username "Jane"
        {:keys [id]} (users/create system username)

        user (users/get-by-id system id)]

    (is (some? user))))
