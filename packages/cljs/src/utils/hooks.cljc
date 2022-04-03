(ns utils.hooks
  (:require [shadow.cljs.devtools.api :as shadow]
            [clojure.java.io :as io]
            [clojure.edn :as edn]))

(intern 'user 'config)

(defn windows? [] (clojure.string/includes? (System/getProperty "os.name") "Windows"))
(defn path [& paths] (clojure.string/join "/" (remove clojure.string/blank? paths)))
(defn parent [filepath] (clojure.string/join "/" (reverse (rest (reverse  (clojure.string/split filepath #"/"))))))

(defn copy-file-to [source target]
  (let [src (io/file source)
        tgt (io/file target)]
    (if (.exists src)
      (let [target-folder (io/file (parent target))]
        (when (not (.isDirectory target-folder))
          (.mkdir target-folder))
        (io/copy src tgt))
      (prn src "not exists"))))

(defn copy-dist [& files]
  (let [config user/config
        target (path (System/getenv "HOME")
                     (if (windows?) "AppData/Local/Screeps/scripts" ".config/Screeps/scripts")
                     (or (:folder config) 
                         (if (:port config) 
                             (clojure.string/join "___" 
                               (remove clojure.string/blank?  
                                 [(clojure.string/replace (:host config) "." "_") (str (:port config))]))
                             (:host config)))
                     (:branch config))]
    (doseq [filename files]
      (copy-file-to 
        (path "./target" filename)
        (path target filename)))))

(defn configure-hook
  {:shadow.build/stage :configure}
  [build-state & args]
  (println "Configure Hook:")
  (println "Select section(default -> local): ")
  (let [-config (edn/read-string (slurp "screeps.edn"))
        ;; -key (keyword (read))
        -key (keyword (or (System/getenv "KIOSS") "default"))
        -keys (keys -config)]
    (intern 'user 'config (get -config (if (= -1 (.indexOf -keys -key)) (first -keys) -key))))
  build-state)

(defn compile-prepare-hook
  {:shadow.build/stage :compile-prepare}
  [build-state & args]
  (println "Compile Prepare Hook:")
  ;; (shadow/release :kioss {:config-merge {:output-to "./test/main.js"}})
  (shadow/release :kioss)
  build-state)

(defn flush-hook
  {:shadow.build/stage :flush}
  [build-state & args]
  (println "Flush Hook:")
  (prn user/config)
  (copy-dist "main.js" "main.js.map")
  build-state)

