(defproject marathonclj "0.1.0"
  :description "Marathon Rest Client for Clojure "
  :url "https://github.com/codemomentum/marathonclj"
  :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                 [cheshire "5.3.1"]
                 [org.clojure/data.json "0.2.5"]
                 [clj-http "0.9.1" :exclusions [org.clojure/clojure]]
                 ]
  :min-lein-version "2.4.3"
  ;release
  :scm {:name "git"
        :url "https://github.com/codemomentum/marathonclj"}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :signing {:gpg-key "218C6198"}
  ;; This directive (and the {:creds :gpg} section) tells
  ;; Leiningen how to find your Clojars account credentials.
  ;; You set those up already, right?
  :deploy-repositories [["clojars" {:creds :gpg}]]
  )
