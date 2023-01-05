(ns esc.system
  (:require [esc.database :as database]))

(defn new
  []
  {:database (database/new)})
