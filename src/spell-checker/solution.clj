(ns spell-checker.solution
  (:require [spell-checker.dictionary :as dictionary]
            [spell-checker.levenshtein :as levenshtein]))

(defn check-spelling [dict word]
  (if (dict word)
    {:result :correct-word}
    {:result     :misspelled-word
     :suggestion (apply min-key (partial levenshtein/distance word) dict)}))

(comment
  "Evaluate the forms bellow to see the results"
  (check-spelling dictionary/words "cavalo")
  (check-spelling dictionary/words "viajem")
  (check-spelling dictionary/words "viajen")
  (check-spelling dictionary/words "vakaa"))
