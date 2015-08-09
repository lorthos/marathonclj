(ns marathonclj.env
  (:import (java.io PushbackReader))
  (:require [clojure.java.io :as io]))

(defn load-props [filename]
  (with-open [r (io/reader filename)]
    (binding [*read-eval* false] (read (PushbackReader. r)))
    ))

(def props (->> "test-config.edn"
                io/resource
                load-props))