(defproject pageler "0.0.1-SNAPSHOT"
  :description "A simple homepage for making new homepages."
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.1.0"]
                 [org.markdownj/markdownj "0.3.0-1.0.2b4"]
                 [org.clojars.jvesala/clojure-couchdb "0.2"]
                 [compojure "0.3.2"]]
  :dev-dependencies [[leiningen-run "0.3"]
		     [leiningen/lein-swank "1.1.0"]]
  :repositories {"scala-tools" "http://scala-tools.org/repo-releases"}
  :main core)