(ns marathonclj.rest.usage
  (:require [marathonclj.rest.apps :as apps]
            [clojure.data.json :as json]
            [marathonclj.rest.info :as info]
            [marathonclj.rest.deployments :as deployments])
  (:import marathonclj.rest.Connection))



(comment


  (def play-app
    (json/read-str (slurp "resources/play-hello.json") :key-fn keyword))

  (def conn (Connection. "http://localhost:8080" {}))


  (apps/create-app conn play-app)

  (deployments/get-deployments conn)

  (apps/get-apps conn)

  (info/server-info conn)




  )
