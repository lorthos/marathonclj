(ns marathonclj.rest.queue
  (:require [marathonclj.common :as r]))

(defn get-queue-content
  "GET /v2/queue"
  []
  (r/get (r/url-with-path "v2" "queue")))