(ns marathonclj.rest.misc
  (:require [marathonclj.common :as r]))


(defn metrics
  "GET /metrics"
  []
  (r/get (r/url-with-path "metrics")))


