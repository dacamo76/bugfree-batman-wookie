(ns bugfree-batman-wookie.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [taoensso.carmine :as car]))

(def counter (atom 0))
(def conn
  (let [uri (System/getenv "REDISTOGO_URL")]
    {:spec {:uri uri}}))

(defn increment [] (swap! counter inc))
(defn redis-increment [] (car/wcar conn (car/incr "hits")))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/count" [] (do (println conn) (str (redis-increment))))
;  (GET "/count" [] (str (increment)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
