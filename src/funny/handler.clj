(ns funny.handler
  (:use compojure.core
        org.httpkit.server)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [cheshire.core :as json]))

(defroutes app-routes
  (GET "/" []
    (str "<p>Hello World</p>"
      "env:<pre>" (json/encode (System/getenv) {:pretty true}) "</pre>"
      "properties<pre>" (json/encode (System/getProperties) {:pretty true}) "</pre>"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    (run-server #'app {:port port})))