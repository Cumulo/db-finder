
(ns edn-finder.comp.keyword
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]
            [respo.alias :refer [create-comp div input button]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]))

(def style-keyword
  {:min-width 120,
   :color :white,
   :text-align :center,
   :background-color colors/attractive,
   :padding "0 8px"})

(defn render [chunk] (fn [state mutate!] (comp-text chunk style-keyword)))

(def comp-keyword (create-comp :keyword render))
