(ns marathonclj.rest.misc
  (:require [marathonclj.rest :as r])
  (:import marathonclj.rest.Connection))


(defn metrics
  "GET /metrics"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "metrics")))


(comment
  (metrics (Connection. "http://localhost:8080" {}))
  )


