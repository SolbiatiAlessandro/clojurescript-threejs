(ns cljs-three-figwheel.core
    (:require ))

(enable-console-print!)

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn startup-app
  []
  ( let [scene (js/THREE.Scene.)
          camera (js/THREE.PerspectiveCamera. 75
                                              (/ (.-innerWidth js/window) (.-innerHeight js/window))
                                              0.1
                                              1000)
          renderer (js/THREE.WebGLRenderer.)
          geometry (js/THREE.BoxGeometry. )
          material (js/THREE.MeshBasicMaterial.
                     (clj->js {:color 0x00ff00})
                     )
          cube (js/THREE.Mesh. geometry material)
          render (fn animate []
                (js/requestAnimationFrame animate)
                 (set! (.-x (.-rotation cube))  (+ 0.01 (.-x (.-rotation cube))) )
                 (set! (.-y (.-rotation cube))  (+ 0.02 (.-y (.-rotation cube))) )
                (.render renderer scene camera)
                   )
         ]
      (.setSize renderer (.-innerWidth js/window) (.-innerHeight js/window))
      (.appendChild (.-body js/document) (.-domElement renderer))
      (.add scene cube)
      (set! (.-z (.-position camera))  5)
      (render)
    )
  )

(startup-app)

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
