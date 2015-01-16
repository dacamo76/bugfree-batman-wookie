(ns bugfree-batman-wookie.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def counter (atom 0))

(defn increment [] (swap! counter inc))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/count" [] (str (increment)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
