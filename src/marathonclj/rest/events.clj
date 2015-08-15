(ns marathonclj.rest.events
  (:require [marathonclj.common :as c]))

(defn get-event-subscriptions
  "GET /v2/eventSubscriptions"
  []
  (c/get (c/url-with-path "v2" "eventSubscriptions")))

(defn register-event-subscription
  "POST /v2/eventSubscriptions"
  [^String call-back-url]
  (c/post (c/url-with-path "v2" "eventSubscriptions" call-back-url))
  )


(defn remove-event-subscription
  "DELETE /v2/eventSubscriptions"
  [^String call-back-url]
  (c/delete (c/url-with-path "v2" "eventSubscriptions" call-back-url))
  )


(defn get-event-stream
  "GET /v2/events

  TODO: https://github.com/mesosphere/marathon/issues/1801"
  []
  (c/get (c/url-with-path "v2" "events")))