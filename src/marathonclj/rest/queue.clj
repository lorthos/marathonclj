(ns marathonclj.rest.queue
  (:require [marathonclj.rest :as r]
            :reload-all)
  (:import marathonclj.rest.Connection))

(defn get-queue-content
  "GET /v2/queue"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "v2" "queue")))