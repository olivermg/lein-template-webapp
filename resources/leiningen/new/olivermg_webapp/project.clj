(defproject clj-factum-service "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [environ "1.1.0"]

                 [clj-chatterbox "0.1.0-SNAPSHOT"]]

  :plugins [[lein-environ "1.1.0"]]

  :source-paths ["src/clj"]
  ;;;:java-source-paths ["src/java"]
  :test-paths ["test/clj"]

  :target-path "target/%s"

  :main ^:skip-aot ow.factum.service.core

  :profiles {:uberjar {:aot :all}}

  )
