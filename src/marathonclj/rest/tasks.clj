(ns marathonclj.rest.tasks
  (:require [marathonclj.rest :as r]
            :reload-all)
  (:import marathonclj.rest.Connection
           clojure.lang.IPersistentMap))


(defn get-tasks
  "GET /v2/tasks"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "v2" "tasks")))
