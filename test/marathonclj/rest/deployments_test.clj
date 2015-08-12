(ns marathonclj.rest.deployments-test
  (:require [clojure.test :refer :all]
            [marathonclj.rest.deployments :as d]
            [marathonclj.rest.apps :as apps]
            [marathonclj.env :as e]
            [marathonclj.common :as c])
  (:import marathonclj.common.Connection)
  )

(def app-descriptor (read-string (slurp "resources/app-descriptor1.edn")))
(def deployments (atom nil))
(c/init! (Connection. (:marathon-url e/props) {}))

(deftest deployments-functionality
  (testing "verify that no app exists"
    (is (= 0 (count (:apps (apps/get-apps))))))
  (testing "create-app"
    (is (= "/001" (:id (apps/create-app app-descriptor))))
    )
  (testing "deployments"
    (is (not (nil? (do
                     (reset! deployments (d/get-deployments))
                     (println @deployments)
                     @deployments))))
    )
  (if (->> @deployments first :id)
    (testing "delete-deployment"
      (is (nil? (d/delete-deployment (->> @deployments first :id) :force true)))
      )
    )
  (testing "delete app"
    (is (contains? (apps/delete-app "001") :deploymentId))
    )

  )



