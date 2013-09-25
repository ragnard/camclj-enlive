(ns camclj-enlive.walkthrough.1-enlive-data
  (:require [clojure.pprint :refer [pprint] :rename {pprint pp}]
            [net.cgrand.enlive-html :as enlive]))

;;--------------------------------------------------------------------
;; enlive data

(def basic-html "<p class=\"test\">Hello</p>")

(pp (enlive/html-snippet basic-html))






(def nested-html "<div class=\"centered\"><p class=\"test\">Hello</p></div>")

(pp (enlive/html-snippet nested-html))



