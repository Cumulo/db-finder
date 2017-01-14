
(ns edn-finder.comp.finder
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.alias :refer [create-comp div input button]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]
            [edn-finder.comp.displayer :refer [comp-displayer]]))

(defn update-state [state new-state] new-state)

(defn init-state [& args] [])

(def style-row {})

(defn render [db]
  (fn [state mutate!]
    (div
     {}
     (div {} (comp-text (pr-str state) nil))
     (div
      {:style (merge ui/row style-row)}
      (->> (range 0 (inc (count state)))
           (map-indexed
            (fn [idx x]
              [idx
               (let [chunk-path (subvec state 0 idx)
                     chunk (if (= idx 0) db (get-in db chunk-path))]
                 (comp-displayer chunk chunk-path mutate!))])))))))

(def comp-finder (create-comp :finder init-state update-state render))
