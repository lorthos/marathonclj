(ns marathonclj.rest.deployments-test
  (:require [clojure.test :refer :all]
            [marathonclj.rest.deployments :as d]
            [marathonclj.rest.apps :as apps]
            [marathonclj.env :as e])
  (:import marathonclj.rest.Connection)
  )

(def app-descriptor (read-string (slurp "resources/app-descriptor1.edn")))

(def conn (Connection. (:marathon-url e/props) {}))

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
      (is (nil? (d/delete-deployment conn (->> @deployments first :id) :force true)))
      )
    )
  (testing "delete app"
    (is (contains? (apps/delete-app conn "001") :deploymentId))
    )

  )



