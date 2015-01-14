# marathonclj

A simple Clojure client for the marathon rest api

## Usage

        (apps/get-apps conn)
        (apps/create-app conn app-descriptor)
        (apps/update-app conn "001" {:cmd "ping 127.0.0.1"} :force true)
        ;check tests for more samples

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

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
