(ns pageler.couchdb
  (:use couchdb.client))
  
(def host "http://localhost:5984/")
(def db-name "pageler")

; (when-not 
;   (contains? (database-list host) db-name)
;   (database-create host db-name))
  
(defn create-page [page]
  (let [record (document-create host db-name page)]
    (:_id record)))
  
(defn get-page [id]
  (document-get host db-name id))

;; Not the nice way of doing it: should pass on _rev
;; and handle error gracefully: somebody else has 
;; already cahnged your file son!
(defn update-page [id page]
  (document-update host db-name id 
    (merge 
      (document-get host db-name id)
      page)))
      
(defn get-ids []
  (document-list host db-name))