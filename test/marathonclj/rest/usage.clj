(ns marathonclj.rest.usage
  (:refer-clojure :exclude [update])
  (:require [marathonclj.rest.apps :as apps]
            [clojure.data.json :as json]
            [marathonclj.rest.info :as info]
            [marathonclj.rest.deployments :as deployments]
            [clojure.pprint :as pp])
  (:import marathonclj.rest.Connection))


(comment

  (def docker-container
    (json/read-str (slurp "resources/docker_example.json") :key-fn keyword))


  (def conn (Connection. "http://10.141.141.10:8080" {}))

  (apps/create-app conn docker-container)

  (deployments/get-deployments conn)

  (apps/get-apps conn)

  (pp/pprint (->> (apps/get-apps conn)
                  :apps
                  first))

  (info/server-info conn)

  (apps/delete-app conn "instance1")

  )