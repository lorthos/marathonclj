(defproject marathonclj "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                           [cheshire "5.3.1"]
                           [org.clojure/data.json "0.2.5"]
                           [clj-http "0.9.1" :exclusions [org.clojure/clojure]]
                           ]
            :min-lein-version "2.4.3")
