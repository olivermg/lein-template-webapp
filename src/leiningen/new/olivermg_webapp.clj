(ns leiningen.new.webapp
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "olivermg-webapp"))

(defn olivermg-webapp
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :src-path-clj (name-to-path name)}]
    (main/info "Generating fresh 'lein new' webapp project.")
    (->files data
             #_["src/{{sanitized}}/foo.clj" (render "foo.clj" data)]
             ["project.clj" (render "project.clj" data)]
             ["{{src-path-clj}}/core.clj" (render "src/core.clj" data)]
             ["{{src-path-clj}}/config.clj" (render "src/config.clj" data)])))
