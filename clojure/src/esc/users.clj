(ns esc.users
  (:require [esc.database :as database]
            [esc.events :as events]))

(defmulti apply-event
          (fn [_ event]
            (:type event)))

(defmethod apply-event :user-created
  [user {:keys [_ payload]}]
  (assoc user :username (:username payload)))

(defn project
  [{:keys [database]} user-id]
  (let [events (database/find-all database :events :stream-id user-id)]
    (reduce apply-event
            {:id user-id}
            events)))

(defn create
  [{:keys [database] :as system} username]
  (let [user-id (random-uuid)]
    (events/add system
                :user-created
                user-id
                {:username username})
    (let [user (project system user-id)]
      (database/upsert database :projections user-id user)
      user)))

(defn all
  [{:keys [database]}]
  (database/all database :projections))

(defn get-by-id
  [{:keys [database]} id]
  (database/find-one database :projections :id id))
