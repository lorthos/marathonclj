(ns marathonclj.rest.groups
  (:require [marathonclj.common :as r])
  (:import clojure.lang.IPersistentMap))

(defn get-groups
  "GET /v2/groups"
  []
  (r/get (r/url-with-path "v2" "groups"))
  )


(defn get-group
  "GET /v2/groups/{groupId}"
  [^String group-id]
  (r/get (r/url-with-path "v2" "group" group-id))
  )

(defn create-group
  "POST /v2/groups"
  [^IPersistentMap group-descriptor]
  (r/post (r/url-with-path "v2" "groups") {:body group-descriptor})
  )

(defn update-group
  "PUT /v2/groups/{groupId}"
  [^String group-id ^IPersistentMap group-descriptor]
  (r/put (r/url-with-path "v2" "groups" group-id) {:body group-descriptor})
  )

(defn delete-group
  "DELETE /v2/groups/{groupId}"
  [^String group-id]
  (r/delete (r/url-with-path "v2" "groups" group-id))
  )
