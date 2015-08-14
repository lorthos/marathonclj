# marathonclj

A simple Clojure client for the marathon rest api

[![Build Status](https://travis-ci.org/codemomentum/marathonclj.png)](https://travis-ci.org/codemomentum/marathonclj.png)

## Usage


          (def docker-container
            (json/read-str (slurp "resources/docker_example.json") :key-fn keyword))

          (c/init! (Connection. "http://10.141.141.10:8080" {}))

          (apps/create-app docker-container)

          (deployments/get-deployments)

          (apps/get-apps)

          (pp/pprint (->> (apps/get-apps)
                          :apps
                          first))

          (info/server-info)

          (apps/delete-app "instance1")

##Artifacts


With Leiningen:

        [marathonclj "0.1.1"]

With Maven:

        <dependency>
          <groupId>marathonclj</groupId>
          <artifactId>marathonclj</artifactId>
          <version>0.1.1</version>
        </dependency>


## Implemented so far

+ crud-app operations
+ version(s)
+ restart
+ task(s)
+ metrics
+ groups
+ tasks
+ deployments
+ event subscriptions
+ queue
+ info

##TODO
+ missing api (0.9, 0.10)
+ doc
+ test


## License

Copyright © 2015 FIXME

Licensed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) (the same as Clojure)
