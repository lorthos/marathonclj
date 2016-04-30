(ns marathonclj.rest.usage
  (:refer-clojure :exclude [update])
  (:require [marathonclj.rest.apps :as apps]
            [clojure.data.json :as json]
            [marathonclj.rest.info :as info]
            [marathonclj.rest.deployments :as deployments]
            [marathonclj.rest.queue :as queue]
            [clojure.pprint :as pp]
            [marathonclj.common :as c])
  (:import marathonclj.common.Connection))


(comment

  (def docker-container
    (json/read-str (slurp "resources/docker_example2.json") :key-fn keyword))

  (c/init! (Connection. "http://10.141.141.10:8080" {}))

  (apps/create-app docker-container)

  (deployments/get-deployments)

  (queue/get-queue-content)

  (apps/get-apps)

  (pp/pprint (->> (apps/get-apps)
                  :apps
                  first))

  (info/server-info)

  (apps/delete-app "instance1")
  (apps/delete-app "instance2")

  )