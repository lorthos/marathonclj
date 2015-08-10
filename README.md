# marathonclj

A simple Clojure client for the marathon rest api

[![Build Status](https://travis-ci.org/codemomentum/marathonclj.png)](https://travis-ci.org/codemomentum/marathonclj.png)

## Usage


        (def docker-container
        (json/read-str (slurp "resources/docker_example.json") :key-fn keyword))


        (def conn (Connection. "http://10.141.141.10:8080" {}))

        (apps/create-app conn docker-container)

        (deployments/get-deployments conn)

        (apps/get-apps conn)

        (info/server-info conn)

        (apps/delete-app conn "instance1")

##Artifacts


With Leiningen:

        [marathonclj "0.1.0"]

With Maven:

        <dependency>
          <groupId>marathonclj</groupId>
          <artifactId>marathonclj</artifactId>
          <version>0.1.0</version>
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
+ missing api
+ doc
+ test


## License

Copyright © 2015 FIXME

Licensed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) (the same as Clojure)
