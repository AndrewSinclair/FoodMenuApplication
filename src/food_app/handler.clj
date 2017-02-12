(ns food-app.handler
  (:require [food-app.database :as db]
            [clojure.string :as string]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defroutes app-routes
  (GET "/" []
    "Hello World")

  (GET "/menus" []
    (db/get-menu-titles))
  
  (route/not-found "Not Found"))


(def app
  (-> app-routes
    wrap-json-response
    (wrap-defaults api-defaults)))
