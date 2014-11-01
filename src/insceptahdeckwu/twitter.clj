(ns insceptahdeckwu.twitter
  (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful])
  (:require [insceptahdeckwu.markov :as markov]))

(defn oauth-creds* [{:keys [api-key api-secret oauth-token oauth-secret]}]
  (make-oauth-creds api-key api-secret oauth-token oauth-secret))

(def oauth-creds
  (memoize oauth-creds*))

(def app-oauth-creds
  (oauth-creds (read-string (slurp "resources/oauth-creds.edn"))))

(def screen-name
  "insceptahdeckwu")

(defn tweet []
  (let [msg (markov/make-formatted-string)]
    (println msg)
    (statuses-update :oauth-creds app-oauth-creds
                     :params {:screen-name screen-name
                              :status msg})))

(defn dry-tweet []
  (let [msg (markov/make-formatted-string)]
    (println msg)))
