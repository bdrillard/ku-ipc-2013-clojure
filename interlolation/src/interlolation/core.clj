(ns interlolation.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn int-vector [line]
  (map read-string (str/split line #" ")))

(defn average [vec1 vec2]
  (apply map (fn [& items]
               (int (Math/floor (/ (apply + items) 2.0)))) [vec1 vec2]))

(defn -main [& args]
  (let [dim (int-vector (read-line))
        img1 (int-vector (read-line))
        toss (read-line)
        dim (read-line)
        img2 (int-vector (read-line))]
    (do
      (println dim)
      (println (str/join " " (average img1 img2))))))
