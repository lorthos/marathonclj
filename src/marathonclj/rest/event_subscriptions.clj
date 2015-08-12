(ns marathonclj.rest.event-subscriptions
  (:require [marathonclj.common :as r]))

(defn get-event-subscriptions
  "GET /v2/eventSubscriptions"
  []
  (r/get (r/url-with-path "v2" "eventSubscriptions")))

(defn register-event-subscription
  "POST /v2/eventSubscriptions"
  [^String call-back-url]
  (r/post (r/url-with-path "v2" "eventSubscriptions" call-back-url))
  )


(defn remove-event-subscription
  "DELETE /v2/eventSubscriptions"
  [^String call-back-url]
  (r/delete (r/url-with-path "v2" "eventSubscriptions" call-back-url))
  )



