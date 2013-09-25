(ns camclj-enlive.walkthrough.2-selection
  (:require [clojure.pprint :refer [pprint] :rename {pprint pp}]
            [net.cgrand.enlive-html :as enlive]))

;;--------------------------------------------------------------------
;; selection

(def html (enlive/html-snippet "<div class=\"centered\">"
                               "<p class=\"test\">Hello</p>"
                               "<p class=\"hest\">World</p>"
                               "</div>"))

(pp html)

(pp (enlive/select html [:div]))

(pp (enlive/select html [:p]))

(pp (enlive/select html [:div :p]))

(pp (enlive/select html [:div :h1]))

(pp (enlive/select html [:div :p.test]))



