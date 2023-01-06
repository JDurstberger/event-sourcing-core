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

(defn find-all
  [database table key value]
  (filter #(= value (key %)) (table @database)))

(defn find-one
  [database table key value]
  (first (filter #(= value (key %)) (table @database))))

(defn upsert
  [database table key entry]
  (swap! database #(update % table conj entry)))
