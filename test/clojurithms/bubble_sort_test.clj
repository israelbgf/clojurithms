(ns clojurithms.bubble-sort-test
  (:require [clojure.test :refer :all]
            [clojurithms.bubble-sort :refer :all]))

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
  (is (= [1 2 3 4] (bubble-sort [3 4 2 1])))
  (is (= [1 2 3 4] (bubble-sort [1 3 4 2]))))


