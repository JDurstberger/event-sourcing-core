(ns esc.events
  (:require
    [esc.database :as database]
    [tick.core :as tick]))

(defn all
  [{:keys [database]}]
  (database/all database :events))

(defn add
  [{:keys [database]} type stream-id payload]
  (database/insert
    database
    :events
    {:created-at (tick/now)
     :id         (random-uuid)
     :type       type
     :stream-id  stream-id
     :payload    payload}))
