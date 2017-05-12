(ns {{name}}.core
  (:require [com.stuartsierra.component :as c]
            [{{name}}.config :refer [config]]
            [ow.chatterbox.core :refer [webapp]])
  (:gen-class))

(defn- run []
  (-> (webapp (config))
      c/start))

(defn -main [& args]
  (let [wa (run)]
    (println "started.")))
