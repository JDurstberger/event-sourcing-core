(ns esc.database)

(defn new
  []
  (atom {:events      []
         :projections []}))

(defn all
  [database table]
  (get @database table))

(defn insert
  [database table entry]
  (swap! database #(update % table conj entry)))
