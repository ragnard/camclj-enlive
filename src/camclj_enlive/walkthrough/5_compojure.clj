(ns camclj-enlive.walkthrough.5-compojure
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [net.cgrand.enlive-html :as enlive]
            
            [camclj-enlive.walkthrough.4-templates :as templates]))

(defn render [seq] (apply str seq))

(defroutes app
  (GET "/" []
       (render (templates/blog "My amazing blog!"
                               [{:title "Post 1" :text "Some content..."}
                                {:title "Post 2" :text "Some different content..."}])))

  (route/not-found "<h1>Page not found</h1>"))



;;--------------------------------------------------------------------
;; auto reloading of sources

(comment

  (do

    (require 'net.cgrand.reload)
    
    (net.cgrand.reload/auto-reload
     (find-ns 'camclj-enlive.walkthrough.4-templates))

    )
  )

;;--------------------------------------------------------------------
;; jetty stuff

(defonce jetty nil)

(defn restart!
  []
  (when jetty (.stop jetty))
  (alter-var-root #'jetty
                  (constantly (jetty/run-jetty #'app {:port 8009
                                                      :join? false}))))

