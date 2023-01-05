(ns esc.profiles
  (:require [esc.events :as events]
            [esc.database :as database]))

(defn create
  [system]
  (events/add system :profile-created {}))

(defn all
  [{:keys [database]}]
  (database/all database :projections))
