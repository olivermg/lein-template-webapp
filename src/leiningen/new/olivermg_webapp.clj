(ns leiningen.new.olivermg-webapp
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]
            [clojure.edn :as edn]))

(def render (renderer "olivermg-webapp"))

(defn- sanitize-opts [opts]
  {:pre [(even? (count opts))]}
  (-> (->> (partition 2 opts)
           (map (fn [[k v]]
                  [(read-string k) v]))
           (into {}))
      (select-keys #{:version})
      (update :version #(or % "0.1.0-SNAPSHOT"))))

(defn olivermg-webapp
  "FIXME: write documentation"
  [name & opts]
  (let [path (name-to-path name)
        data (merge {:name name
                     :path path
                     :src-path-clj (str "src/clj/" path)
                     :src-path-java (str "src/java/" path)
                     :test-path-clj (str "test/clj/" path)}
                    (sanitize-opts opts))]
    (main/info "Generating fresh 'lein new' webapp project.")
    (->files data
             [".gitignore" (render ".gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["{{src-path-clj}}/core.clj" (render "src/core.clj" data)]
             ["{{src-path-clj}}/config.clj" (render "src/config.clj" data)])))
