(ns pageler.markdown
  (:import com.petebevin.markdown.MarkdownProcessor))
  
(def processor (MarkdownProcessor.))

(defn markdown [md] (.markdown processor md))