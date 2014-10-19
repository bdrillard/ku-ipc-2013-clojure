(ns trash.core
  (:gen-class))

(defn -main [& args]
  (let [line (read-line)]
    (println (apply str
           (map #(char (read-string (str "0" %)))
                (re-seq #"x[\d|[a-f]|[A-F]]{2}" line))))))
