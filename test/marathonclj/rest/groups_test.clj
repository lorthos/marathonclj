(ns marathonclj.rest.groups-test
  (:require [clojure.test :refer :all]
            [marathonclj.rest.groups :as g]
            [marathonclj.rest.apps :as apps])
  (:import marathonclj.rest.Connection)
  )

(def app-descriptor (read-string (slurp "resources/app-descriptor1.edn")))

(def conn (Connection. "http://localhost:8080" {}))


(deftest deployments-functionality
  (testing "verify that no app exists"
    (is (= 0 (count (:apps (apps/get-apps conn))))))
  (testing "create-app"
    (is (= "/001" (:id (apps/create-app conn app-descriptor))))
    )
  (testing "groups"
    (is (= 0  (count (:groups (g/get-groups conn )))))
    )

  (testing "delete app"
    (is (contains? (apps/delete-app conn "001") :deploymentId))
    )
  )



