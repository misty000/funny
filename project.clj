(defproject funny "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.1.6"]
                 [http-kit "2.1.14"]

                 [cheshire "5.5.0"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler funny.handler/app}
  :main funny.handler
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
