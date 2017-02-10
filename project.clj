(defproject food-app "0.1.0-SNAPSHOT"
  :description "Food menu application"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [org.clojure/java.jdbc "0.7.0-alpha1"]
                 [postgresql "9.1-901.jdbc4"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-exec "0.3.1"]]
  :ring {:handler food-app.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
