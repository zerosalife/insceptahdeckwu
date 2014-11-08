(ns insceptahdeckwu.core
  (:require [insceptahdeckwu.corpus :as corpus]
            [insceptahdeckwu.markov :as markov]
            [insceptahdeckwu.twitter :as twitter]
            [clojure.string :as string]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def cli-options
  [["-c" "--corpus" "Make corpus and save in resources directory"
    :flag true]
   ["-s" "--string" "Print a markov generated tweet to the command line."
    :flag true]
   ["-t" "--tweet" "Tweet a markov generated tweet."
    :flag true]
   ["-h" "--help"
    :default false
    :flag true]])

(defn usage [options-summary]
  (->> ["insceptahdeckwu is a parody twitter bot that tweets based on
  a markov chain derived from a corpus of Wu-tang Clan lyrics."
        ""
        "Usage: insceptahdeckwu [options]"
        ""
        "Options:"
        options-summary
        ""
        "Please refer to the readme for more information."]
       (string/join \newline)))

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (string/join \newline errors)))

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn -main
  [& args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (cond
     (:help options) (exit 0 (usage summary))

     errors (exit 1 (error-msg errors)))
    (cond
     (:corpus options) (do (corpus/make-corpus-text-and-save)
                           (exit 0 (str
                                    "Corpus successfully created in:\n    "
                                    corpus/corpus-filename))))
    (cond
     (:string options) (markov/print-string))
    (cond
     (:tweet options) (do (twitter/tweet)
                          (exit 0 "Successfully tweeted.")))))
