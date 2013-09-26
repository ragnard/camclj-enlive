(ns camclj-enlive.walkthrough.4-templates
  (:require [clojure.pprint :refer [pprint] :rename {pprint pp}]
            [net.cgrand.enlive-html :as enlive]))

;;--------------------------------------------------------------------
;; templating

;; snippets are functions that can transform a part of a document

(enlive/defsnippet post "walkthrough/blog.html" [:.post]
  [title text]

  [:h1]
  (enlive/content title)

  [:p]
  (enlive/content text))

(comment

  (pp (post "Hello" "My first post!"))

  )




;; templates are functions that can transform an entire document,
;; returning a sequence of strings

(enlive/deftemplate blog-with-title "walkthrough/blog.html"
  [title]

  [:head :title]
  (enlive/content title))


(comment

  (pp (blog-with-title "My amazing blog"))

  )

;; useful helper function that turns a seq of strings into a single string
(defn render
  [seq]
  (apply str seq))

(comment

  (pp (render (blog-with-title "My amazing blog")))

  )


;; replace 

(enlive/deftemplate blog "walkthrough/blog.html"
  [title posts]

  [:head :title]
  (enlive/content title)

  [:#posts]
  (enlive/content (map #(post (:title %) (:text %)) posts)))

(comment

  (pp (render (blog "My amazing blog"
                    [{:title "Post 1" :text "Some interesting text"}
                     {:title "Post 2" :text "Some more text"}])))


  )




