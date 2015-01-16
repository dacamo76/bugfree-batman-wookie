(defproject bugfree-batman-wookie "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [com.taoensso/carmine "2.9.0"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler bugfree-batman-wookie.core.handler/app}
  :profiles
  {:uberjar {:aot :all}
   :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
