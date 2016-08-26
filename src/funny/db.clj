(ns funny.db
  (:require [clojure.java.jdbc :as jdbc]))

(def db-spec "jdbc:h2:./test")

(defn test-db [] (jdbc/query db-spec "SELECT * FROM table1"))