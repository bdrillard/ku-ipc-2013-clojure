(ns range.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn rad->deg [rad]
  (* rad (/ 180 Math/PI)))

(defn range-calc [d v]
  (let [arg (/ (* d 9.8) (Math/pow v 2))]
   (if (<= arg 1.0)
     (format "%.4f" (rad->deg (/ (Math/asin arg) 2)))
     "no possible angle")))

(defn -main [& args]
  (doseq [line (line-seq (java.io.BufferedReader. *in*))]
    (let [[d v] (map read-string (str/split line #" "))]
      (println (range-calc d v)))))
