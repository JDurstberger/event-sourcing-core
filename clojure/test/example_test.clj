(ns example_test
  (:require [clojure.test :refer :all]))

(deftest example
  (testing "can add numbers"
    (is (= 2 (+ 1 1)))))
