(ns food-app.d
  (:require [clojure.java.jdbc :refer all]))


(let [db-host "localhost"
      db-port 5432
      db-name "food-app"]

  (def db {:classname "org.postgresql.Driver" ; must be in classpath
           :subprotocol "postgresql"
           :subname (str "//" db-host ":" db-port "/" db-name)
           ; Any additional keys are passed to the driver
           ; as driver-specific properties.
           :user "food-app"
           :password "food-app"}))

(defn get-menus []
  (with-connection db 
     (with-query-results rs ["select * from menu"] 
       ; rs will be a sequence of maps, 
       ; one for each record in the result set. 
       (dorun (map #(println (:title %)) rs)))))
