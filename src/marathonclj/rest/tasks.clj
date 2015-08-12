(ns marathonclj.rest.tasks
  (:require [marathonclj.common :as r]))


(defn get-tasks
  "GET /v2/tasks"
  []
  (r/get (r/url-with-path "v2" "tasks")))
