(ns marathonclj.rest.queue
  (:require [marathonclj.common :as c]))

(defn get-queue-content
  "GET /v2/queue"
  []
  (c/get (c/url-with-path "v2" "queue")))

(defn reset-delay
  "DELETE /v2/queue/{appId}/delay"
  [^String appid]
  (c/delete (c/url-with-path "v2" "queue" appid "delay"))
  )