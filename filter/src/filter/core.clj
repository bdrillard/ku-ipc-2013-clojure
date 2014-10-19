(ns filter.core
  (:gen-class))

(defn balanced? [line]
  (loop [s (seq line) r 0]
    (cond
      (or (empty? s) (neg? r)) (if (= 0 r) true false)
      (= (first s) \() (recur (rest s) (+ r 1))
      (= (first s) \)) (recur (rest s) (- r 1))
      :else (recur (rest s) r))))

(defn -main [& args]
  (doseq [line (line-seq (java.io.BufferedReader. *in*))]
    (if (balanced? line)
      (println "balanced")
      (println "unbalanced"))))
