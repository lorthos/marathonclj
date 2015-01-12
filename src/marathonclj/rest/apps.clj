(ns marathonclj.rest.apps
  (:require [marathonclj.rest :as r] :reload-all)
  (:import marathonclj.rest.Connection
           clojure.lang.IPersistentMap))


(defn get-apps
  "GET /v2/apps"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "v2" "apps")))

(comment
  (get-apps (Connection. "http://localhost:8080" {}))
  )

(defn get-app
  "GET /v2/apps/{appId}"
  [^Connection conn ^String app-id]
  (r/get conn (r/url-with-path conn "v2" "apps" app-id)))

(comment
  (get-app (Connection. "http://localhost:8080" {}) "001")
  )

(defn delete-app
  "DELETE /v2/apps/{appId}"
  [^Connection conn ^String app-id]
  (r/delete conn (r/url-with-path conn "v2" "apps" app-id)))

(comment
  (delete-app (Connection. "http://localhost:8080" {}) "001")
  )


(defn create-app
  "POST /v2/apps"
  [^Connection conn ^IPersistentMap app-descriptor]
  (r/post conn (r/url-with-path conn "v2" "apps") {:body app-descriptor})
  )

(comment
  (create-app (Connection. "http://localhost:8080" {})
              (read-string (slurp "resources/app-descriptor1.edn")))
  )