(ns food-app.handler
  (:require [food-app.database :as db]
            [clojure.string :as string]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" []
    "Hello World")

  (GET "/menus" []
    (string/join \newline (db/get-menu-titles)))
  
  (route/not-found "Not Found"))


(def app
  (wrap-defaults app-routes site-defaults))
