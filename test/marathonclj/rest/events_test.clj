(ns marathonclj.rest.events-test
  (:require [clojure.test :refer :all]
            [marathonclj.rest.apps :as apps]
            [clojure.data.json :as json]
            [marathonclj.env :as env]
            [marathonclj.common :as c]
            [marathonclj.rest.events :as e])
  (:import marathonclj.common.Connection)
  )

(c/init! (Connection. (:marathon-url env/props) {}))


;TODO https://github.com/mesosphere/marathon/issues/1801
(deftest deployments-functionality
  (testing "get event stream"
    (is (= 1 1
           ;(e/get-event-stream)
           )))
  )


