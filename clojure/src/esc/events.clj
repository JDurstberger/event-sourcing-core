(ns esc.events
  (:require
    [esc.database :as database]
    [tick.core :as tick]))

(defn all
  [{:keys [database]}]
  (database/all database :events))

(defn add
  [{:keys [database]} type payload]
  (database/insert
    database
    :events
    {:created-at (tick/now)
     :type type
     :payload payload}))
