(ns funny.handler
  (:use compojure.core
        org.httpkit.server)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [cheshire.core :as json]
            [funny.db :as db]))

(defroutes app-routes
  (GET "/" []
    (str
      "<title>Mayday</title>"
      "<p>Hello Funny</p>"
      "<a href='env'>Env</a>"))
  (GET "/env" []
    (str
      "<title>Mayday</title>"
      "<p>Hello World</p>"
      "<p>test db: " (json/encode (db/test-db)) "</p>"
      "env:<pre>" (json/encode (System/getenv) {:pretty true}) "</pre>"
      "properties<pre>" (json/encode (System/getProperties) {:pretty true}) "</pre>"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    (run-server #'app {:port port})))