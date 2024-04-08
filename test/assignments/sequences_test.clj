(ns assignments.sequences-test
  (:require [clojure.test :refer [deftest testing is are]]
            [assignments.sequences :as s]))

(deftest ^:kaocha/pending max-of-pairs
  (testing "max of pairs with 0 elements"
    (is (= [] (s/max-of-pairs []))))
  (testing "max of pairs with 1 element"
    (is (= [1] (s/max-of-pairs [1]))))
  (testing "max of pairs with 2 elements"
    (is (= [2] (s/max-of-pairs [1 2]))))
  (testing "max of pairs with more than 2 elements"
    (are [x y] (= x (s/max-of-pairs y))
      [2 3] [1 2 3]
      [2 3 4] [1 2 3 4]
      [2 3 4 5] [1 2 3 4 5]
      [3 3] [3 3 3]
      [2 2 3] [1 2 1 3])))

(deftest ^:kaocha/pending filter-by-index
  (testing "filter-by-index returns elements at odd indices"
    (are [result pred coll] (= result (s/filter-by-index pred coll))
      [] odd? []
      [] odd? [1]
      [2] odd? [1 2 3]
      [2 4] odd? [1 2 3 4]
      [2 4] odd? [1 2 3 4 5]))
  (testing "filter-by-index returns elements at even indices"
    (are [result pred coll] (= result (s/filter-by-index pred coll))
      [] even? []
      [1] even? [1]
      [1 3] even? [1 2 3]
      [1 3] even? [1 2 3 4]
      [1 3 5] even? [1 2 3 4 5]))
  (testing "filter-by-index returns elements at custom indices"
    (are [result pred coll] (= result (s/filter-by-index pred coll))
      [] #{0 1 4 5} []
      [1] #{0 1 4 5} [1]
      [1 2] #{0 1 4 5} [1 2]
      [1 2] #{0 1 4 5} [1 2 3]
      [1 2] #{0 1 4 5} [1 2 3 4]
      [1 2 5] #{0 1 4 5} [1 2 3 4 5]
      [1 2 5 6] #{0 1 4 5} [1 2 3 4 5 6])))