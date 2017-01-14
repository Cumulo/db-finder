
(ns edn-finder.comp.entry
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]
            [respo.alias :refer [create-comp div input button]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]))

(def style-value
  {:min-width 80,
   :color :white,
   :text-align :center,
   :background-color colors/motif-light,
   :max-width 200})

(def style-entry
  {:min-width 120,
   :color :white,
   :text-align :center,
   :background-color colors/motif-dark,
   :cursor :pointer})

(def comp-entry
  (create-comp
   :entry
   (fn [data on-display]
     (fn [state mutate!]
       (cond
         (map? data)
           (div
            {:style style-entry, :event {:click on-display}}
            (comp-text (str "Map:" (count data)) nil))
         (vector? data)
           (div
            {:style style-entry, :event {:click on-display}}
            (comp-text (str "Vector:" (count data)) nil))
         (set? data)
           (div
            {:style style-entry, :event {:click on-display}}
            (comp-text (str "Set:" (count data)) nil))
         (number? data) (comp-text (pr-str data) style-value)
         (string? data) (comp-text (pr-str data) style-value)
         (keyword? data) (comp-text (pr-str data) style-value)
         (boolean? data) (comp-text (pr-str data) style-value)
         (nil? data) (comp-text "nil" style-value)
         :else (comp-text (str "Not recognized " (pr-str data)) nil))))))
