(ns marathonclj.rest.apps-test
  (:require [clojure.test :refer :all]
            [marathonclj.rest.apps :as apps]
            [clojure.data.json :as json]
            [marathonclj.env :as e]
            [marathonclj.common :as c])
  (:import marathonclj.common.Connection)
  )

(def app-descriptor (json/read-str (slurp "resources/app-descriptor1.json") :key-fn keyword))
(def version (atom nil))
(c/init! (Connection. (:marathon-url e/props) {}))

(deftest crud-functionality
  (testing "verify that no app exists"
    (is (= 0 (count (:apps (apps/get-apps))))))
  (testing "create-app"
    (is (= "/http1" (:id (apps/create-app app-descriptor))))
    )
  (testing "get-app"
    (is (contains? (apps/get-app "/http1") :app))
    (is (= "python -m SimpleHTTPServer 9999" (->> (apps/get-app "/http1") :app :cmd)))
    )
  (testing "verify that get-apps works with query params"
    (is (= 1 (count (:apps (apps/get-apps))))))
  (testing "verify that get-apps works with query params"
    (is (= 0 (count (:apps (apps/get-apps :cmd "non-existing"))))))
  (testing "verify that get-apps works with query params"
    (is (= 1 (count (:apps (apps/get-apps :cmd "python -m SimpleHTTPServer 9999"))))))
  (testing "list versions"
    (is (string? (do
                   (reset! version (first (:versions (apps/versions "http1"))))
                   @version)))
    )
  (testing "get-version"
    (is (contains? (apps/version "http1" @version) :id)))
  (testing "update app"
    (is (= "ping 127.0.0.1" (do
                              (apps/update-app "http1" {:cmd "ping 127.0.0.1"} :force true)
                              (->> (apps/get-app "/http1") :app :cmd))))
    )
  (testing "restart-app"
    (is (not-empty (apps/restart-app "http1" :force true)))
    )
  (testing "tasks"
    (is (contains? (apps/tasks "http1") :tasks))
    )
  (testing "kill-tasks"
    (is (contains? (apps/kill-tasks "http1" :host "localhost" :scale false) :tasks))
    )
  (testing "delete-task"
    (is (thrown? Exception (apps/kill-task "http1" "task-id" :scale false) :tasks)) ;task-id does not exists
    )
  (testing "delete app"
    (is (contains? (apps/delete-app "http1") :deploymentId))
    )
  )


