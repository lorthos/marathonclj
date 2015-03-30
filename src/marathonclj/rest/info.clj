(ns marathonclj.rest.info
  (:require [marathonclj.rest :as r])
  (:import marathonclj.rest.Connection))

(defn server-info
  "GET /v2/info"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "v2" "info")))
