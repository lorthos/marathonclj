(ns marathonclj.rest.apps
  (:require [marathonclj.common :as r])
  (:import (clojure.lang IPersistentMap)))


(defn get-apps
  "GET /v2/apps"
  [& args]
  (r/get (r/url-with-path "v2" "apps") {:query-params (r/->opts args)})
  )

(defn get-app
  "GET /v2/apps/{appId}"
  [^String app-id]
  (r/get (r/url-with-path "v2" "apps" app-id)))

(defn delete-app
  "DELETE /v2/apps/{appId}"
  [^String app-id]
  (r/delete (r/url-with-path "v2" "apps" app-id)))

(defn create-app
  "POST /v2/apps"
  [^IPersistentMap app-descriptor]
  (r/post (r/url-with-path "v2" "apps") {:body app-descriptor})
  )

(defn versions
  "GET /v2/apps/{appId}/versions"
  [^String app-id]
  (r/get (r/url-with-path "v2" "apps" app-id "versions")))

(defn version
  "GET /v2/apps/{appId}/versions/{version}"
  [^String app-id ^String version]
  (r/get (r/url-with-path "v2" "apps" app-id "versions" version)))

(defn update-app
  "PUT /v2/apps/{appId}"
  [^String app-id ^IPersistentMap app-descriptor & args]
  (r/put (r/url-with-path "v2" "apps" app-id)
         {:body app-descriptor :query-params (r/->opts args)})
  )

(defn restart-app
  "POST /v2/apps/{appId}/restart"
  [^String app-id ^Boolean & args]
  (r/post (r/url-with-path "v2" "apps" app-id "restart") {:query-params (r/->opts args)})
  )

(defn tasks
  "GET /v2/apps/{appId}/tasks"
  [^String app-id]
  (r/get (r/url-with-path "v2" "apps" app-id "tasks"))
  )

(defn kill-tasks
  "DELETE /v2/apps/{appId}/tasks"
  [^String app-id & args]
  (r/delete (r/url-with-path "v2" "apps" app-id "tasks")
            {:query-params (r/->opts args)})
  )

(defn kill-task
  "DELETE /v2/apps/{appId}/tasks/{taskId}"
  [^String app-id ^String task-id & args]
  (r/delete (r/url-with-path "v2" "apps" app-id "tasks" task-id)
            {:query-params (r/->opts args)})
  )