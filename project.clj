(defproject funny "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [http-kit "2.2.0"]

                 [cheshire "5.6.3"]
                 [com.layerware/hugsql "0.4.7"]
                 [com.h2database/h2 "1.4.192"]
                 [javax.servlet/servlet-api "2.5"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-ancient "0.6.10"]]
  :ring {:handler funny.handler/app}
  :main funny.handler
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
