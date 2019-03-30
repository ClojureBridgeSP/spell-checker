(ns spell-checker.levenshtein)

(defn- cost [word-a word-b]
  (if (= (last word-a) (last word-b))
    0
    1))

(declare distance)
(defn- distance* [word-a word-b]
  (let [cost (cost word-a word-b)]
    (min
     (inc (distance (subs word-a 0 (dec (count word-a))) word-b))
     (inc (distance word-a (subs word-b 0 (dec (count word-b)))))
     (+ cost (distance (subs word-a 0 (dec (count word-a))) (subs word-b 0 (dec (count word-b))))))))

(defn- distance [word-a word-b]
  (cond
    (empty? word-a) (count word-b)
    (empty? word-b) (count word-a)
    :else (distance* word-a word-b)))
