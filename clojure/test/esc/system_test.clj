(ns esc.system-test
  (:require [clojure.test :refer :all]
            [esc.events :as events]
            [esc.profiles :as profiles]
            [esc.system :as system]))

(deftest no-profiles-exist-by-default
  (let [system (system/new)]
    (testing "profiles are empty"
      (is (empty? (profiles/all system))))))

(deftest no-events-exist-by-default
  (let [system (system/new)]
    (testing "events are empty"
      (is (empty? (events/all system))))))

(deftest creating-a-profile-creates-event
  (let [system (system/new)]

    (profiles/create system)

    (testing "one event created"
      (is (= 1 (count (events/all system)))))))
