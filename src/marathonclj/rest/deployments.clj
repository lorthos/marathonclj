(ns marathonclj.rest.deployments
  (:require [marathonclj.common :as r]))

(defn get-deployments
  "GET /v2/deployments"
  []
  (r/get (r/url-with-path "v2" "deployments")))

(defn delete-deployment
  "DELETE /v2/deployments/{deploymentId}"
  [^String deployment-id & args]
  (r/delete (r/url-with-path "v2" "deployments" deployment-id) {:query-params (r/->opts args)})
  )
