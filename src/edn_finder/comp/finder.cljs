
(ns edn-finder.comp.finder
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.alias :refer [create-comp div input button]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]))

(defn update-state [state new-state] new-state)

(defn init-state [& args] [])

(defn render [db]
  (fn [state mutate!]
    (div
     {}
     (div {} (comp-text (pr-str state) nil))
     (div
      {}
      (->> (range 0 (inc (count state)))
           (map-indexed (fn [idx x] [idx (div {} (comp-text (str "something" x idx)))])))))))

(def comp-finder (create-comp :finder init-state update-state render))
