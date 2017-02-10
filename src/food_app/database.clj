(ns food-app.database
  (:require [clojure.java.jdbc :refer :all]))


(let [db-host "localhost"
      db-port 5432
      db-name "foodapp"]

  (def db {:classname "org.postgresql.Driver" ; must be in classpath
           :subprotocol "postgresql"
           :subname (str "//" db-host ":" db-port "/" db-name)
           ; Any additional keys are passed to the driver
           ; as driver-specific properties.
           :user "foodapp"
           :password "foodapp"}))

(defn get-menu-titles []
  (with-db-connection [c db] 
     (->>
       (query c ["select * from menu"])
       (map :title))))
