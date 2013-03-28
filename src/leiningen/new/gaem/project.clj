(defproject {{appname}} "{{version}}"
  :description "FIXME: write description"
  :min-lein-version "2.0"
  :url {{proj-url}}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repl-options {:port 4005
                 :init-ns {{name}}.core
                 :init (do
                         (require '[appengine-magic.core :as ae])
                         (in-ns '{{name}}.user)
                         (clojure.core/compile '{{name}}.request)
                         (clojure.core/compile '{{name}}.user)
                         (ae/start {{name}}-user)
                         (println "here we are in" *ns*))}
  :gae-sdk "{{sdk}}"
  :gae-app {:id "{{gae-app-id}}"
            ;; using - prefix on version nbr forces use to customize
            :version  {:dev "-{{gae-app-version}}"
                       :test "-{{gae-app-version}}"
                       :prod "-{{gae-app-version}}"}
            :servlets [{{#servlets}}{:name "{{name}}", :class "{{class}}",
                       :services [{{#services}}{:svcname {{svcname}} :action {{action}} :path  "{{path}}"}
                                  {{/services}}]}
                       {{/servlets}}]
            :war "{{war}}"
            :display-name "{{display-name}}"
            :welcome "{{welcome}}"
            :threads {{threads}},
            :sessions {{sessions}},
            :java-logging "{{java-logging}}",
            ;; static-files: html, css, js, etc.
            :statics {:src "src/main/public"
                      :dest ""
                      :include {:pattern "public/**"
                                ;; :expire "5d"
                                }
                      ;; :exclude {:pattern "foo/**"}
                      }
            ;; resources: img, etc. - use lein default
            :resources {:src "src/main/resource"
                        :dest ""
                        :include {:pattern "public/**"
                                  ;; :expire "5d"
                                  }
                        ;; :exclude {:pattern "bar/**"}
                        }
            }
  :aot [{{#aots}}{{aot}} {{/aots}}]
  :compile-path "{{war}}/WEB-INF/classes"
  :target-path "{{war}}/WEB-INF/lib"
  :uberjar-exclusions [#"META-INF/DUMMY.SF"
                       #"appengine-tools-api-1.7.4.jar"
                       #"appengine-local.*"
                       #"appengine-api.*"]
  :keep-non-project-classes false
  :omit-source true ;; default
  :jar-exclusions [#"^WEB-INF/appengine-generated.*$"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [ring/ring-core "1.2.0-beta1"]
                 [ring/ring-devel "1.2.0-beta1"]
                 [hiccup "1.0.2"]
                 [org.clojure/tools.logging "0.2.3"]
                 ;; dev-deps not currently found on classpath, so put
                 ;; ae here until a fix is found
                 [appengine-magic "0.5.1-SNAPSHOT"]]
  :dev-dependencies [[appengine-magic "0.5.1-SNAPSHOT"]]
  :profiles {:dev {:aot ^:replace []}
;;                   :prep-tasks ["gaem clean"]}
                   }
  :plugins [[gaem "0.1.0-SNAPSHOT"]
            ;; [appengine-magic "0.5.1-SNAPSHOT"]
            ])
