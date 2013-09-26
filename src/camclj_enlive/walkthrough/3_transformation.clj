(ns camclj-enlive.walkthrough.3-transformation
  (:require [clojure.pprint :refer [pprint] :rename {pprint pp}]
            [net.cgrand.enlive-html :as enlive]))

;;--------------------------------------------------------------------
;; transformation

(def html (str "<div class=\"centered\">"
               "<p class=\"test\">Hello</p>"
               "<p class=\"hest\">World</p>"
               "</div>"))

(comment
  
  (pp html)

  ;; return node untouched
  (pp (enlive/sniptest html
                       [:p.test]
                       (fn [node] node)))













  
  ;; remove node by returning nil
  (pp (enlive/sniptest html
                       [:p.test]
                       (fn [node] nil)))







  

  ;; update node content
  (pp (enlive/sniptest html
                       [:p.test]
                       (fn [node] (assoc node :content "Goodbye"))))








  
  ;; update node content in all `p` elements
  (pp (enlive/sniptest html
                       [:p]
                       (fn [node] (assoc node :content "Goodbye"))))


  ;;--------------------------------------------------------------------
  ;; transformation functions

  ;; update node content in all `p` elements
  (pp (enlive/sniptest html
                       [:p]
                       (enlive/content "Goodbye")))






  
  ;; add a class
  (pp (enlive/sniptest html
                       [:div]
                       (enlive/add-class "selected")))










  
  ;; remove a class and update content
  (pp (enlive/sniptest html
                       [:div]
                       (enlive/do-> (enlive/remove-class "centered")
                                    (enlive/content "Goodbye"))))


  ;; transform multiple parts of input
  (pp (enlive/sniptest html
                       [:p.test]
                       (enlive/add-class "a")

                       [:p.hest]
                       (enlive/add-class "b")))

  )

;; a possible, but less than ideal way of creating a re-usable
;; template fn
(defn centered-div-template
  [text]
  (enlive/sniptest html
                   [:div]
                   (enlive/content text)))


(comment

  (pp (centered-div-template "Hello World!"))

  )
