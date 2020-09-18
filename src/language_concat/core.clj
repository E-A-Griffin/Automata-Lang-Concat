(ns language-concat.core
  (:require [clojure.string :as s])
  (:gen-class))


(defn l-expt [l n]
        (flatten
         (nth
          (iterate
           (fn [x] (flatten ((apply juxt (for [i l] (fn [y] (map #(str % i) y)))) x))) l) (dec n))))

(def superscript-map
  ;; Superscript digits 0-3 are not contiguous
  (zipmap (range 10)
          (concat [\⁰ \¹ \² \³] (map char (range (long \⁴) (+ 6 (long \⁴)))))))

(defn super-n
  "Transforms a number n->ⁿ, returning a string"
  [n]
  (reduce str (map (comp superscript-map read-string str) (str n))))

(defn lang->output-str [l n]
  (let [L (l-expt l n)
        tail-str ",\n     "]
    (str "L" (super-n n) "= {"
                       (reduce str
                               (drop-last (count tail-str) ;; Remove ",\n      " on last line
                                          (reduce str
                                                  (map
                                                   #(str
                                                     (s/join ", " %) tail-str)
                                                   (partition 4 L)))))
                       "}\n and has size: " (count L))))

(defn -main
  "Takes optional command-line args and prompts user for input if none
   are supplied. If command-line args are passed, given a language of size n,
   the first n arguments are treated as the elements of the language, and the
   n+1th element is the number of times to concatenate the language.
   For example the command-line call could be:
     java -jar l-concat.jar a ab 2
   which would produce
     L²= {aa, aba, aab, abab}
      and has size: 4"
  [& args]
  (if args
    (let [[elements n-list] (split-at (dec (count args)) args)
          n (read-string (first n-list))]
      (println (lang->output-str elements n)))
    (do (doall (map println
                    ["Enter the (finite) language you want to concatenate in the format:"
                     "    a aa aaa aaaa"
                     "For example, if you have the language"
                     "L = {a, ab, ba, bbb}, you should enter:"
                     "    a ab ba bbb"]))
        (let [response (read-line)
              elements (s/split response #" ")]
          (do (println "Enter the number of times you would like to concatenate your language: ")
              (let [n (read-string (read-line))]
                (println (lang->output-str elements n))))))))
