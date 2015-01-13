(ns marathonclj.rest.groups
  (:require [marathonclj.rest :as r]
            :reload-all)
  (:import marathonclj.rest.Connection
           clojure.lang.IPersistentMap))

(defn get-groups
  "GET /v2/groups"
  [^Connection conn]
  (r/get conn (r/url-with-path conn "v2" "groups"))
  )


(defn get-group
  "GET /v2/groups/{groupId}"
  [^Connection conn ^String group-id]
  (r/get conn (r/url-with-path conn "v2" "group" group-id))
  )

(defn create-group
  "POST /v2/groups"
  [^Connection conn ^IPersistentMap group-descriptor]
  (r/post conn (r/url-with-path conn "v2" "groups") {:body group-descriptor})
  )

(defn update-group
  "PUT /v2/groups/{groupId}"
  [^Connection conn ^String group-id ^IPersistentMap group-descriptor]
  (r/put conn (r/url-with-path conn "v2" "groups" group-id) {:body group-descriptor})
  )

(defn delete-group
  "DELETE /v2/groups/{groupId}"
  [^Connection conn ^String group-id]
  (r/delete conn (r/url-with-path conn "v2" "groups" group-id))
  )
