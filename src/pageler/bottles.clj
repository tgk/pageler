(ns pageler.bottles
  (:use [clojure.contrib.str-utils2 :only (capitalize)]))

(defn bottles-str [bottles]
  (str
    (cond
      (= 0 bottles) "no more bottles"
      (= 1 bottles) "1 bottle"
      :else (str bottles " bottles"))
    " of beer"))

(defn first-line []
  (map 
    #(capitalize (format "%s on the wall, %s." (bottles-str %) (bottles-str %))) 
    (iterate inc 0)))

(defn second-line []
  (map 
    #(format "Take one down and pass it around, %s on the wall." (bottles-str %)) 
    (iterate inc 0)))
    
(defn sing [bottles]
  (concat
    (rest
      (reverse
        (interleave 
          (take bottles (first-line))
          (take bottles (second-line))
          )))
    [(format "Go to the store and buy some more, %s on the wall." (bottles-str bottles))]))
  
(defn -main [& args]
  (dorun (map println (sing 5))))