(ns marathonclj.rest.apps
  (:require [marathonclj.rest :as r])
  (:import marathonclj.rest.Connection
           (clojure.lang IPersistentMap)))


(defn get-apps
  "GET /v2/apps"
  [^Connection conn & args]
  (r/get conn (r/url-with-path conn "v2" "apps") {:query-params (r/->opts args)}))

(defn get-app
  "GET /v2/apps/{appId}"
  [^Connection conn ^String app-id]
  (r/get conn (r/url-with-path conn "v2" "apps" app-id)))

(defn delete-app
  "DELETE /v2/apps/{appId}"
  [^Connection conn ^String app-id]
  (r/delete conn (r/url-with-path conn "v2" "apps" app-id)))

(defn create-app
  "POST /v2/apps"
  [^Connection conn ^IPersistentMap app-descriptor]
  (r/post conn (r/url-with-path conn "v2" "apps") {:body app-descriptor})
  )

(defn versions
  "GET /v2/apps/{appId}/versions"
  [^Connection conn ^String app-id]
  (r/get conn (r/url-with-path conn "v2" "apps" app-id "versions")))

(defn version
  "GET /v2/apps/{appId}/versions/{version}"
  [^Connection conn ^String app-id ^String version]
  (r/get conn (r/url-with-path conn "v2" "apps" app-id "versions" version)))

(defn update-app
  "PUT /v2/apps/{appId}"
  [^Connection conn ^String app-id ^IPersistentMap app-descriptor & args]
  (r/put conn (r/url-with-path conn "v2" "apps" app-id)
         {:body app-descriptor :query-params (r/->opts args)})
  )

(defn restart-app
  "POST /v2/apps/{appId}/restart"
  [^Connection conn ^String app-id ^Boolean & args]
  (r/post conn (r/url-with-path conn "v2" "apps" app-id "restart") {:query-params (r/->opts args)})
  )

(defn tasks
  "GET /v2/apps/{appId}/tasks"
  [^Connection conn ^String app-id]
  (r/get conn (r/url-with-path conn "v2" "apps" app-id "tasks"))
  )

(defn kill-tasks
  "DELETE /v2/apps/{appId}/tasks"
  [^Connection conn ^String app-id & args]
  (r/delete conn (r/url-with-path conn "v2" "apps" app-id "tasks")
            {:query-params (r/->opts args)})
  )

(defn kill-task
  "DELETE /v2/apps/{appId}/tasks/{taskId}"
  [^Connection conn ^String app-id ^String task-id & args]
  (r/delete conn (r/url-with-path conn "v2" "apps" app-id "tasks" task-id)
            {:query-params (r/->opts args)})
  )