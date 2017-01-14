
(ns edn-finder.comp.loader
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.alias :refer [create-comp div input button]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]
            [cljs.reader :refer [read-string]]))

(defn update-state [state k v] (assoc state k v))

(defn on-load [url] (fn [e dispatch!] (dispatch! :load-data url)))

(def style-input {:width 400})

(def style-container {})

(defn two-way [mutate! path state]
  {:event {:input (fn [e dispatch!] (mutate! path (:value e)))},
   :attrs {:value (get state path)}})

(defn init-state [] {:url "http://repo.cumulo.org/woodenlist/woodenlist-storage.edn"})

(def comp-loader
  (create-comp
   :loader
   init-state
   update-state
   (fn []
     (fn [state mutate!]
       (div
        {:style style-container}
        (input
         (merge-with
          merge
          {:style (merge ui/input style-input),
           :attrs {:placeholder "URL for EDN file...", :type "url"}}
          (two-way mutate! :url state)))
        (comp-space 8 nil)
        (button
         {:style ui/button, :event {:click (on-load (:url state))}}
         (comp-text "Load" nil)))))))
