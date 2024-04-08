(ns assignments.sequences)

(defn max-of-pairs
  "Returns the maximum of each pair of elements in coll"
  {:level :easy
   :use   '[map max rest]
   :alternates '[repeat partition]}
  [coll])

(defn filter-by-index
  "Returns elements of coll at even indices"
  {:level :easy
   :use   '[keep-indexed]}
  [pred coll])