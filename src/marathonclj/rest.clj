(ns marathonclj.rest
  (:refer-clojure :exclude [get])
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [clojure.string :refer [join]]
            [marathonclj.patch :as patch])
  (:import java.net.URLEncoder
           clojure.lang.IPersistentMap))

(defrecord Connection
  [^String uri ^IPersistentMap http-opts])

(def ^{:const true} slash "/")
(def ^:dynamic throw-exceptions true)

(defn url-with-path
  [^Connection conn & segments]
  (str (.uri conn) slash (join slash segments)))


(defn post-string
  [^Connection conn ^String uri {:keys [body] :as options}]
  (json/decode (:body (http/post uri (merge (.http-opts conn) options
                                            {:accept :json :body body}))) true))

(defn post
  ([^Connection conn ^String uri]
    (post conn uri {}))
  ([^Connection conn ^String uri {:keys [body] :as options}]
    (http/with-middleware patch/middleware
                          (json/decode (:body (http/post uri
                                                         (merge (.http-opts conn) options
                                                                {:accept :json :content-type :json :body (json/encode body)})
                                                         )) true)
                          )))

(defn put
  [^Connection conn ^String uri {:keys [body] :as options}]
  (http/with-middleware patch/middleware
                        (json/decode (:body (http/put uri (merge (.http-opts conn) options
                                                                 {:accept :json :content-type :json :body (json/encode body) :throw-exceptions throw-exceptions}))) true)
                        )
  )

(defn get
  ([^Connection conn ^String uri]
    (json/decode (:body (http/get uri (merge (.http-opts conn) {:accept :json :throw-exceptions throw-exceptions}))) true))
  ([^Connection conn ^String uri options]
    (json/decode (:body (http/get uri (merge (.http-opts conn) options
                                             {:accept :json :throw-exceptions throw-exceptions}))) true)))

(defn head
  [^Connection conn ^String uri]
  (http/head uri (merge (.http-opts conn) {:accept :json :throw-exceptions throw-exceptions})))

(defn delete
  ([^Connection conn ^String uri]
    (http/with-middleware patch/middleware
                          (json/decode (:body (http/delete uri (merge (.http-opts conn)
                                                                      {:accept :json :content-type :json :throw-exceptions throw-exceptions}))) true)))
  ([^Connection conn ^String uri {:keys [body] :as options}]
    (http/with-middleware patch/middleware
                          (json/decode (:body (http/delete uri (merge (.http-opts conn) options
                                                                      {:accept :json :content-type :json :body (json/encode body) :throw-exceptions throw-exceptions}))) true))))


(defn ->opts
  "Coerces arguments to a map"
  [args]
  (let [x (first args)]
    (if (map? x)
      x
      (apply array-map args))))

