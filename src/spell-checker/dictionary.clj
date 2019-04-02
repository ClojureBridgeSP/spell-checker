(ns spell-checker.dictionary
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def pt-br "pt_BR.dic")

(defn- split-at-line-breaks [text]
  (string/split text (re-pattern (System/lineSeparator))))

(defn- build-dictionary [dict-file]
  (->> dict-file
      io/resource
      slurp
      split-at-line-breaks
      (mapcat #(string/split % #"-"))
      (filter #(>= (count %) 2))
      (map string/lower-case)
      set))

(defonce words (build-dictionary pt-br))
