(ns marathonclj.rest.deployments
  (:require [marathonclj.rest :as r]
            :reload-all)
  (:import marathonclj.rest.Connection))

(defn get-deployments
  "GET /v2/deployments"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "v2" "deployments")))

(defn delete-deployment
  "DELETE /v2/deployments/{deploymentId}"
  [^Connection conn ^String deployment-id ^Boolean force?]
  (r/delete conn (r/url-with-path conn "v2" "deployments" (if force?
                                                            (str deployment-id "?scale=true")
                                                            deployment-id)))
  )
