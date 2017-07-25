(ns marathonclj.rest.events-test
  (:require [clojure.test :refer :all]
            [marathonclj.rest.apps :as apps]
            [clojure.data.json :as json]
            [marathonclj.env :as e]
            [marathonclj.common :as c]
            [marathonclj.rest.events :as events])
  (:import marathonclj.common.Connection)
  )

(defn test-wrapper
  [f]
  (let [marathon-available?
        (try
          (assert (not (nil? (slurp (:marathon-url e/props)))))
          (c/init! (Connection. (:marathon-url e/props) {}))
          (println "marathon available...")
          true
          (catch Exception e
            (.printStackTrace e)
            (println "skipping test...")
            false))]
    (if marathon-available?
      (f))))

(use-fixtures :once test-wrapper)


;TODO https://github.com/mesosphere/marathon/issues/1801
(deftest deployments-functionality
  (testing "get event stream"
    (is (= 1 1
           ;(e/get-event-stream)
           )))
  )


