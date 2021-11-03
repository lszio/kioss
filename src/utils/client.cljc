(ns utils.client
  (:require [shadow.cljs.devtools.api :as shadow]
            [clojure.java.io :as io]))

(defn get-config [section]
  (get (with-open [rdr (clojure.java.io/reader "./screeps.edn")]
         (clojure.edn/read (java.io.PushbackReader. rdr))) section))

(defn file-path [& paths]
  (clojure.string/join "/" (remove clojure.string/blank? paths)))

(defn copy-to [source target]
  (let [src (io/file source)
        tgt (io/file target)]
    (if (.exists src)
      (io/copy src tgt)
      nil)))

(defn windows? []
  (clojure.string/includes? (System/getProperty "os.name") "Windows"))

(defn copy-src []
  (prn "copy sources")
  (let [config (get-config :local)]
    (for [filename ["main.js" "main.map.js"]]
      (let [source (file-path "./target" filename)
            target (file-path
                    (System/getenv "HOME")
                    (if (windows?) "AppData/Local/Screeps/scripts" ".config/Screeps/scripts")
                    (clojure.string/join "___"
                                         (remove clojure.string/blank?
                                                 [(clojure.string/replace (:host config) "." "_")
                                                  (str (:port config))]))
                    (:branch config)
                    filename)]
        (copy-to source target)))))

(defn hook
  {:shadow.build/stage :compile-prepare}
  [build-state & args]
  (shadow/release :kioss)
  (copy-src)
  build-state)