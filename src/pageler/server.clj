(ns pageler.server
  (:use 
    compojure
    (pageler markdown couchdb bottles)))
  
(defn generate-page [page]
  (html
    [:html
      [:head
        [:title (:title page)]]
      [:body 
        [:h1 (:title page)]
        (markdown (:contents page))]]))
  
(defroutes pageler-app
  (GET "/"
    (map str (get-ids) (repeat "\n")))
  (GET "/:bottles/bottles"
    (html 
      (interleave 
        (sing 
          (min 1000 (Integer/parseInt (:bottles params))))
        (repeat [:br]))))
  (GET "/:id"
    (generate-page
      (get-page (:id params))))
  (ANY "*"
    (page-not-found)))

(defn run-pageler-server []
  (run-server {:port 8080}
    "/*" (servlet pageler-app)))