(defproject insceptahdeckwu "0.1.0-SNAPSHOT"
  :description "A Wu-tang Clan parody markov twitter bot."
  :url "http://github.com/zerosalife/insceptahdeckwu"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [enlive "1.0.0"]
                 [org.clojure/tools.cli "0.3.1"]
                 [janiczek/markov "0.3.0"]
                 [twitter-api "0.7.7"]
                 [org.slf4j/slf4j-log4j12 "1.7.7"]]
  :main ^:skip-aot insceptahdeckwu.core
  :target-path "target/%s"
  :bin {:name "insceptahdeckwu"}
  :profiles {:uberjar {:aot :all}})
