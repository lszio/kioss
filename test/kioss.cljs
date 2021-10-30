(ns kioss.tets
    (:require [clojure.test :as test]
              [kioss]))

(test/deftest main-loop-test []
    (test/is (kioss.main-loop)))