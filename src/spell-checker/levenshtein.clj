(ns spell-checker.levenshtein
  (:import (org.apache.commons.text.similarity LevenshteinDistance)))

(def ^:private levenshtein (LevenshteinDistance.))

(defn distance [word-a word-b]
  (.apply levenshtein word-a word-b))
