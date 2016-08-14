(ns clojure-katas.core-test
  (:require [clojure.test :refer :all]
            [clojure-katas.core :refer :all]))

(defn- to-tail-if-greater
  [coll val]
    (cond
      (empty? coll) (list val)
      (> (last coll) val)
        (concat (butlast coll) [val] [(last coll)])
      :else
        (concat coll [val])))

(defn- bubble-up [coll]
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

(deftest how-to-tail-if-greater
  (testing "Returns a coll with val added to tail if greatest than current one, otherwise added to before last."
    (is (= [1] (to-tail-if-greater [] 1)))
    (is (= [0 1 2] (to-tail-if-greater [0 2] 1)))
    (is (= [0 2 7] (to-tail-if-greater [0 2] 7)))))

(deftest how-bubble-up
  (testing "Returns a coll with the greatest value at last."
    (is (= [] (bubble-up [])))
    (is (= [1] (bubble-up [1])))
    (is (= [1 2] (bubble-up [1 2])))
    (is (= [1 2] (bubble-up [2 1])))
    (is (= [0 1 2] (bubble-up [2 0 1])))
    (is (= [1 2 0 3] (bubble-up [3 1 2 0])))))

(deftest empty-when-empty
  (is (= [] (bubble-sort []))))

(deftest same-when-one-element
  (is (= [1] (bubble-sort [1]))))

(deftest same-when-already-ordered
  (is (= [1 2] (bubble-sort [1 2]))))

(deftest ordered-when-unordered-coll-of-two-items
  (is (= [1 2] (bubble-sort [2 1]))))

(deftest ordered-when-three-or-more-items
  (is (= [1 2 3] (bubble-sort [2 3 1])))
  (is (= [1 2 3] (bubble-sort [3 2 1])))
  (is (= [1 2 3 4] (bubble-sort [3 4 2 1])))
  (is (= [1 2 3 4] (bubble-sort [1 3 4 2]))))


