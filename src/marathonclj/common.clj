(ns marathonclj.common
  (:refer-clojure :exclude [get])
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [clojure.string :refer [join]]
            [marathonclj.patch :as patch])
  (:import clojure.lang.IPersistentMap))

(defrecord Connection
  [^String uri ^IPersistentMap http-opts])

(def ^:dynamic *mconn* (atom nil))

(def ^{:const true} slash "/")
(def ^:dynamic *throw-exceptions* true)

(defn init! [^Connection conn]
  (reset! *mconn* conn))

(defn url-with-path
  [& segments]
  (str (.uri @*mconn*) slash (join slash segments)))


(defn post-string
  [^String uri {:keys [body] :as options}]
  (json/decode (:body (http/post uri (merge (.http-opts @*mconn*) options
                                            {:accept :json :body body}))) true))

(defn post
  ([^String uri]
   (post uri {}))
  ([^String uri {:keys [body] :as options}]
   (http/with-middleware patch/middleware
                         (json/decode (:body (http/post uri
                                                        (merge (.http-opts @*mconn*) options
                                                               {:accept :json :content-type :json :body (json/encode body) :throw-exceptions *throw-exceptions*})
                                                        )) true)
                         )))

(defn put
  [^String uri {:keys [body] :as options}]
  (http/with-middleware patch/middleware
                        (json/decode (:body (http/put uri (merge (.http-opts @*mconn*) options
                                                                 {:accept :json :content-type :json :body (json/encode body) :throw-exceptions *throw-exceptions*}))) true)
                        )
  )

(defn get
  ([^String uri]
   (json/decode (:body (http/get uri (merge (.http-opts @*mconn*) {:accept :json :throw-exceptions *throw-exceptions*}))) true))
  ([^String uri options]
   (json/decode (:body (http/get uri (merge (.http-opts @*mconn*) options
                                            {:accept :json :throw-exceptions *throw-exceptions*}))) true)))

(defn head
  [^String uri]
  (http/head uri (merge (.http-opts @*mconn*) {:accept :json :throw-exceptions *throw-exceptions*})))

(defn delete
  ([^String uri]
   (http/with-middleware patch/middleware
                         (json/decode (:body (http/delete uri (merge (.http-opts @*mconn*)
                                                                     {:accept :json :content-type :json :throw-exceptions *throw-exceptions*}))) true)))
  ([^String uri {:keys [body] :as options}]
   (http/with-middleware patch/middleware
                         (json/decode (:body (http/delete uri (merge (.http-opts @*mconn*) options
                                                                     {:accept :json :content-type :json :body (json/encode body) :throw-exceptions *throw-exceptions*}))) true))))


(defn ->opts
  "Coerces arguments to a map"
  [args]
  (let [x (first args)]
    (if (map? x)
      x
      (apply array-map args))))

