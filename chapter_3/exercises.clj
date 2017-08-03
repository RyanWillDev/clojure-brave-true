(defn add-100
  [num]
  (+ num 100))

(defn dec-maker
  [dec-by]
  (fn [num]
    (- dec-by num)))

(def dec-by-4 (dec-maker 4))

(defn match
  [{part :name size :size}]
  (let [unmatched-list (filter #(not (clojure.string/includes? part %)) (list "top-" "right-" "bottom-" "left-"))]
    (map (fn [unmatched]
          (hash-map :name (str unmatched (second (clojure.string/split part #"-")) ) :size size))
        unmatched-list)))

(defn sym-alien
  [asym-parts]
  (reduce (fn [final-parts part]
            (into final-parts (set [part (match part)])))
          []
          asym-parts))

(def alien [{:name "top-eye" :size 1} {:name "bottom-leg" :size 3}])

(sym-alien alien)

(add-100 4)

(str "Does this work " (add-100 4) " I wonder")

(def my-vec (map #(+ % 1) (vector 1 2 3)))

(def my-list (list 2 3 4 5))

(def my-set (hash-set my-list my-vec))

(def my-map (map :name "Ryan" :age "27"))
