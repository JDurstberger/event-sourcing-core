(ns example_test
  (:require [clojure.test :refer :all]))

(deftest example
  (testing "can add numbers"
    (is (= 3 (+ 1 1)))))
