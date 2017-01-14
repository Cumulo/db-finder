
(ns edn-finder.comp.displayer
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.alias :refer [create-comp div input button]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]
            [edn-finder.comp.keyword :refer [comp-keyword]]
            [edn-finder.comp.entry :refer [comp-entry]]))

(defn on-display [path mutate!] (fn [e dispatch!] (mutate! path)))

(def style-row {:margin-bottom 8})

(defn render-map [chunk path mutate-finder!]
  (div
   {}
   (->> chunk
        (map
         (fn [entry]
           (let [[k v] entry]
             [k
              (div
               {:style (merge ui/row style-row)}
               (comp-keyword k)
               (comp-entry v (on-display (conj path k) mutate-finder!)))]))))))

(def style-container {:white-space :nowrap, :margin-right 16})

(defn render-any [chunk] (div {} (comp-text (pr-str chunk) nil)))

(def comp-displayer
  (create-comp
   :displayer
   (fn [chunk path mutate-finder!]
     (fn [state mutate!]
       (div
        {:style style-container}
        (cond (map? chunk) (render-map chunk path mutate-finder!) :else (render-any chunk)))))))
