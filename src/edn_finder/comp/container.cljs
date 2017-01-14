
(ns edn-finder.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.alias :refer [create-comp div span]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]
            [edn-finder.comp.loader :refer [comp-loader]]
            [edn-finder.comp.finder :refer [comp-finder]]))

(def style-container {:padding 16})

(def comp-container
  (create-comp
   :container
   (fn [store]
     (fn [state mutate!]
       (div
        {:style (merge ui/global style-container)}
        (comp-loader)
        (comp-space nil 8)
        (comp-finder (:data store)))))))
