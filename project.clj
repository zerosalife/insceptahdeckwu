(defproject insceptahdeckwu "0.1.0-SNAPSHOT"
  :description "A Wu-tang Clan parody markov twitter bot."
  :url "http://github.com/zerosalife/insceptahdeckwu"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [enlive "1.0.0"]
                 [org.clojure/tools.cli "0.3.1"]]
  :main ^:skip-aot insceptahdeckwu.core
  :target-path "target/%s"
  :bin {:name "insceptahdeckwu"}
  :profiles {:uberjar {:aot :all}})
