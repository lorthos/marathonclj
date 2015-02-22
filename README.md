# marathonclj

A simple Clojure client for the marathon rest api

[![Build Status](https://travis-ci.org/codemomentum/marathonclj.png)](https://travis-ci.org/codemomentum/marathonclj.png)

## Usage

With a descriptor like the following:

    {
    "id": "http",
    "cmd": "python -m SimpleHTTPServer 9999",
    "mem": 50,
    "cpus": 0.1,
    "instances": 1,
    "constraints": [
        ["hostname", "UNIQUE"]
        ]
    }


        (apps/get-apps conn)
        (apps/create-app conn app-descriptor)
        (apps/update-app conn "001" {:cmd "python -m SimpleHTTPServer 8888"} :force true)
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
