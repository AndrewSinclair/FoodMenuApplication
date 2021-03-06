(ns food-app.handler
  (:require [food-app.database         :as     db]
            [clojure.string            :as     string]
            [compojure.core            :refer  :all]
            [compojure.route           :as     route]
            [clojure.tools.logging     :refer  [info error]]
            [ring.middleware.logger    :refer  [wrap-with-logger]]
            [ring.middleware.json      :refer  [wrap-json-response wrap-json-body]]
            [ring.middleware.defaults  :refer  [wrap-defaults api-defaults]]
            [ring.util.response        :refer  [response]]
            [ring.middleware.cors      :refer  [wrap-cors]]
            [clj-time.core             :as     time]
            [buddy.sign.jwt            :as     jwt]
            [buddy.auth                :refer  [authenticated? throw-unauthorized]]
            [buddy.auth.backends.token :refer  [jws-backend]]
            [buddy.auth.middleware     :refer  [wrap-authentication wrap-authorization]]))

(def secret "mysupersecret")

(defn ok [d] {:status 200 :body d})
(defn bad-request [d] {:status 400 :body d})


;; TODO: Extract the `authenticated?` check to generalize for multiple routes:
;;  https://adambard.com/blog/buddy-password-auth-example/
(defn home
  [request]
  (if-not (or (authenticated? request) (System/getenv "SKIP_AUTH"))
    (throw-unauthorized)
    (ok {:status "Logged" :message (str "hello logged user "
                                        (:identity request))})))

(defn login
  [request]
  (let [username (get-in request [:body :username])
        password (get-in request [:body :password])
        valid?   (db/auth-user username password)]
    (if valid?
      (let [claims {:user (keyword username)
                    :exp (time/plus (time/now) (time/seconds 3600))}
            token (jwt/sign claims secret {:alg :hs512})]
        (ok {:token token}))
      (bad-request {:message "wrong auth data"}))))

;; (defroutes admin-routes
;;   (GET "/" [] get-admin))

(defroutes app-routes
  (GET "/" []
    home)

  (POST "/login" []
    login)

  (GET "/menus" []
    (db/get-menus))


  ;; (context "/admin" []
  ;;   (restrict admin-routes {:handler is-authenticated}))
  
  (route/not-found "Not Found"))


(def auth-backend (jws-backend {:secret secret :options {:alg :hs512}}))

(def app
  (-> app-routes
    (wrap-cors :access-control-allow-origin [#"http://localhost:\d{4}"]
               :access-control-allow-methods [:get :put :post :delete])
    (wrap-authorization auth-backend)
    (wrap-authentication auth-backend)
    wrap-with-logger
    wrap-json-response
    (wrap-json-body {:keywords? true :bigdecimals? true})
    (wrap-defaults api-defaults)))
