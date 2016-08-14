(ns clojure-katas.bubble-sort
  (:gen-class))

(defn to-tail-if-greater
  [coll val]
  (cond
    (empty? coll)
      [val]
    (> (peek coll) val)
      (into (pop coll) [val (peek coll)])
    :else
      (conj coll val)))

(defn bubble-up [coll]
  (reduce to-tail-if-greater [] coll))

(defn bubble-sort
  [unsorted-coll]
  (loop [sorted ()
         unsorted unsorted-coll]
    (if (empty? unsorted)
      sorted
      (let [coll-with-greatest-at-end (bubble-up unsorted)]
        (recur (conj sorted (peek coll-with-greatest-at-end))
               (pop coll-with-greatest-at-end))))))
