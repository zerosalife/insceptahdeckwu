(ns insceptahdeckwu.markov
  (:require [markov.core :as markov]
            [insceptahdeckwu.corpus :refer [corpus-filename]]
            [clojure.string :refer [join]]))

;;; First order (def order 1), seems to give better rhyming, with the
;;; drawback of more repition (wrt the original source) in the lyrics.
;;; It will produce random walks of a pretty large length (18-20)
;;; without stopping on untrained states.  Third order seems good for
;;; producing more meaningful text, but it halts after walks of about
;;; 4 items.  Since we're going for a rap-like generated text, the
;;; rhyming and repitition of first order is fine.
(def order 1)

(def transition-matrix (markov/build-from-file order corpus-filename))

(defn rand-int-6-18 []
  (+ 6 (rand-int 12)))

(defn generate-string []
  (take (rand-int-6-18)
        (markov/generate-walk transition-matrix)))

(defn make-formatted-string []
  (join " " (generate-string)))

(defn print-string []
  (println (make-formatted-string)))
