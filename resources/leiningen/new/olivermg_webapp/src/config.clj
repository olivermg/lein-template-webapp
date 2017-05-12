(ns ow.factum.service.config
  (:require [environ.core :refer [env]]))

(defn get-config []
  {:webserver {:server {:port 8899}

               :all {:dev? true}

               :site {:handler (fn [req] {:status 200})}

               :api {:handler (fn [req] {:status 201})
                     :prefix "/api"}}})
