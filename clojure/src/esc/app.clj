(ns esc.app
  (:require
    [cli4clj.cli :as cli]
    [clojure.pprint :as pprint]
    [esc.events :as events]
    [esc.users :as users]
    [esc.system :as system]))

(defn -main [& args]
  (let [system (system/new)]
    (cli/start-cli {:cmds
                    {:get-events  {:fn         (fn [] (pprint/pprint (events/all system)))
                                   :short-info "Gets all events"}
                     :create-user {:fn         (fn [] (users/create system))
                                   :short-info "Creates a new user"}}
                    :alternate-height 3
                    :entry-message    (str "This is a CLI to interact with the system!" "\n"
                                           "\n"
                                           "To see a list of available commands, type <Tab>." "\n"
                                           "To exit this interactive cli tool, type \"q\".")})))
