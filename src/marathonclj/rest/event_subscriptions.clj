(ns marathonclj.rest.event-subscriptions
  (:require [marathonclj.rest :as r])
  (:import marathonclj.rest.Connection))

(defn get-event-subscriptions
  "GET /v2/eventSubscriptions"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "v2" "eventSubscriptions")))

(defn register-event-subscription
  "POST /v2/eventSubscriptions"
  [^Connection conn ^String call-back-url]
  (r/post conn (r/url-with-path conn "v2" "eventSubscriptions" call-back-url))
  )


(defn remove-event-subscription
  "DELETE /v2/eventSubscriptions"
  [^Connection conn ^String call-back-url]
  (r/delete conn (r/url-with-path conn "v2" "eventSubscriptions" call-back-url))
  )



