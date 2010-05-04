(ns core
  (:use (pageler markdown couchdb server)))

; (defn test-couchdb []
;   (let [id (create-page {:title "My awesome page" :contents "_misc_"})]
;     (println (get-page id))
;     (println (update-page id {:title "More awesome" :contents "_MISC_"}))))
; 
; (defn -main [& args]
;   (test-couchdb))
  
(defn -main [& args]
  (run-pageler-server))

; (defn -main [& args]
;   (when-not (empty? args)
;     (println (markdown (first args)))
;     (recur (rest args))))

