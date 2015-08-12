(ns marathonclj.rest.info
  (:require [marathonclj.common :as r]))

(defn server-info
  "GET /v2/info"
  []
  (r/get  (r/url-with-path  "v2" "info")))
