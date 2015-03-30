(ns marathonclj.rest.deployments
  (:require [marathonclj.rest :as r])
  (:import marathonclj.rest.Connection))

(defn get-deployments
  "GET /v2/deployments"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "v2" "deployments")))

(defn delete-deployment
  "DELETE /v2/deployments/{deploymentId}"
  [^Connection conn ^String deployment-id & args]
  (r/delete conn (r/url-with-path conn "v2" "deployments" deployment-id) {:query-params (r/->opts args)})
  )
