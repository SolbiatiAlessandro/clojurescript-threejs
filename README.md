# cljs-three-figwheel

An example setup for ClojureScript and three.js

## Overview

Trying to go over the [three.js getting started](https://threejs.org/docs/index.html#manual/en/introduction/Creating-a-scene) using ClojureScript instead of vanilla Javascript.

To set up three.js you need to 
1. download the three.js library and put it somewhere in the project
2. edit project.clj adding
```
:foreign-libs [{:file "resources/public/js/three.min.js"  :provides ["three"]}
:externs ["resources/public/js/three.ext.js"]
```

Some similar repo:
- https://github.com/gzmask/tetris-cljs-figwheel
- https://github.com/thheller/shadow-cljs

## Setup

To get an interactive development environment run:

    npm install
    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
