(ns clojurithms.bubble-sort)

(defn to-tail-if-greater
  [coll val]
  (if (empty? coll)
    [val]
    (if (> (peek coll) val)
      (into (pop coll) [val (peek coll)])
      (conj coll val))))

(defn bubble-up
  [coll]
  (reduce to-tail-if-greater [] coll))

(defn bubble-sort
  [coll]
  (loop [sorted ()
         unsorted coll]
    (if (empty? unsorted)
      sorted
      (let [greatest-at-tail (bubble-up unsorted)]
        (recur (conj sorted (peek greatest-at-tail))
               (pop greatest-at-tail))))))
