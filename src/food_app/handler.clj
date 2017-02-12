(ns food-app.handler
  (:require [food-app.database        :as     db]
            [clojure.string           :as     string]
            [compojure.core           :refer  :all]
            [compojure.route          :as     route]
            [clojure.tools.logging    :refer  [info error]]
            [ring.middleware.logger   :refer  [wrap-with-logger]]
            [ring.middleware.json     :refer  [wrap-json-response]]
            [ring.middleware.defaults :refer  [wrap-defaults api-defaults]]
            [ring.util.response       :refer  [response]]))

(defroutes app-routes
  (GET "/" []
    "Hello World")

  (GET "/menus" []
    (db/get-menu-titles))
  
  (route/not-found "Not Found"))


(def app
  (-> app-routes
    wrap-with-logger
    wrap-json-response
    (wrap-defaults api-defaults)))
