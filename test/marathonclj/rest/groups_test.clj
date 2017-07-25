(ns marathonclj.rest.groups-test
  (:require [clojure.test :refer :all]
            [marathonclj.rest.groups :as g]
            [marathonclj.rest.apps :as apps]
            [marathonclj.env :as e]
            [marathonclj.common :as c])
  (:import marathonclj.common.Connection)
  )

(def app-descriptor (read-string (slurp "resources/app-descriptor1.edn")))


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


(deftest deployments-functionality
  (testing "verify that no app exists"
    (is (= 0 (count (:apps (apps/get-apps))))))
  (testing "create-app"
    (is (= "/001" (:id (apps/create-app app-descriptor))))
    )
  (testing "groups"
    (is (= 0 (count (:groups (g/get-groups)))))
    )

  (testing "delete app"
    (is (contains? (apps/delete-app "001") :deploymentId))
    )
  )



