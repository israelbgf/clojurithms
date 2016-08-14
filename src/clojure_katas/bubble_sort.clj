(ns clojure-katas.bubble-sort
  (:gen-class))

(defn to-tail-if-greater
  [coll val]
  (cond
    (empty? coll)
      (list val)
    (> (last coll) val)
      (concat (butlast coll) [val] [(last coll)])
    :else
      (concat coll [val])))

(defn bubble-up [coll]
  (reduce to-tail-if-greater [] coll))

(defn bubble-sort
  [unsorted-coll]
  (loop [sorted ()
         unsorted unsorted-coll]
    (if (empty? unsorted)
      sorted
      (let [greatest-at-end (bubble-up unsorted)]
        (recur (conj sorted (last greatest-at-end))
               (butlast greatest-at-end))))))
