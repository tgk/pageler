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

(def 
 new-page 
 (html
  [:html
   [:head
    [:title "Create new page"]]
   [:body
    [:h1 "Create a new page"]
    [:p "Fill out the fields to create a new page."]
    (form-to [:post "/submit-page"]
	     (text-field "title" "Page title")
	     (text-area "contents" "#Write contents here")
	     (submit-button "Create page"))]]))

(defn submit-page
  [title contents]
  (let [id (create-page {:title title :contents contents})]
    (redirect-to (format "/%s" id))))
      

(defroutes pageler-app
  (GET "/" new-page)
  (GET "/new-page" new-page)
  (POST "/submit-page" (submit-page (params :title) (params :contents)))
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