(ns marathonclj.rest.deployments-test
  (:require [clojure.test :refer :all]
            [marathonclj.rest.deployments :as d]
            [marathonclj.rest.apps :as apps]
            [marathonclj.rest :as r])
  (import marathonclj.rest.Connection)
  )

(def app-descriptor (read-string (slurp "resources/app-descriptor1.edn")))

(def conn (r/Connection. "http://localhost:8080" {}))

(def deployments (atom nil))


(deftest deployments-functionality
  (testing "verify that no app exists"
    (is (= 0 (count (:apps (apps/get-apps conn))))))
  (testing "create-app"
    (is (= "/001" (:id (apps/create-app conn app-descriptor))))
    )
  (testing "deployments"
    (is (not (nil? (do
                     (reset! deployments (d/get-deployments conn))
                     (println @deployments)
                     @deployments))))
    )
  (if (->> @deployments first :id)
    (testing "delete-deployment"
      (is (contains? (d/delete-deployment conn (->> @deployments first :id) :force true) :version))
      )
    )
  (testing "delete app"
    (is (contains? (apps/delete-app conn "001") :deploymentId))
    )

  )



