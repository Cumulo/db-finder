
(ns edn-finder.comp.entry
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]
            [respo.alias :refer [create-comp div input button]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]))

(def style-entry
  {:min-width 120,
   :color :white,
   :text-align :center,
   :background-color colors/verdant,
   :cursor :pointer})

(defn render [data on-display]
  (fn [state mutate!]
    (cond
      (map? data) (div {:style style-entry, :event {:click on-display}} (comp-text "Map" nil))
      (vector? data) (div {:event {:click on-display}} (comp-text "Vector" nil))
      (set? data) (comp-text "Set" nil)
      (number? data) (comp-text "Number" nil)
      (string? data) (comp-text "String" nil)
      (keyword? data) (comp-text "Keyword" nil)
      (nil? data) (comp-text "nil" nil)
      :else (comp-text (str "Not recognized " (pr-str data)) nil))))

(def comp-entry (create-comp :entry render))
