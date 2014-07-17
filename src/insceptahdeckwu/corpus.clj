(ns insceptahdeckwu.corpus
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as s]))

(def corpus-filename "resources/cleaned/corpus.txt")

(defn only-files
  "Filter a sequence of files/directories by the .isFile property of
  java.io.File.  From
  https://github.com/clojure-cookbook/clojure-cookbook/blob/master/04_local-io/4-07_get-files-from-directory/4-07_get-files-from-directory.asciidoc"
  [file-seq]
  (filter #(.isFile %) file-seq))

(defn extract-lyric-content [f]
  "Extract the lyric content of interest from the file f."
  (let [dom (html/html-resource
             (java.io.StringReader. (slurp f)))]
    (->
     (html/select dom [[:pre]])
     first
     :content
     first)))

(defn contains-char? [the-string the-char]
  (some #(= the-char %) the-string))

(defn valid-string? [s]
  "Valid strings are non-empty strings that do not contain
  [ (commonly used to denote parts of the song and which rappers are
  rapping) and : (commonly used in the album info and transcriber
  info)."
  (and (not (contains-char? s \[))
       (not (contains-char? s \:))
       (not (contains-char? s \"))
       (not (contains-char? s \())
       (not (empty? s))))

(defn make-corpus-text []
  "Returns a sequence of strings containing the text of the cleaned
  corpus constructed from resources/raw."
  (let [files (only-files (file-seq  (clojure.java.io/file "resources/raw")))
        s-seq (map extract-lyric-content files)
        corpus-text  (map #(s/join " "
                                   (filter valid-string?
                                           (s/split % #"\n")))
                          s-seq)]
    corpus-text))

(defn make-corpus-text-and-save []
  "Creates and saves the text of the corpus to the file defined in
  `corpus-filename'.  This is the main function in the
  insceptahdeckwu.corpus namespace.  Therefore it prints side effects
  to play nice with the commandline."
  (let [corpus-text (make-corpus-text)]
    (spit corpus-filename (s/join " " corpus-text))))
