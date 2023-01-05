#!/usr/bin/env bash

[ -n "$DEBUG" ] && set -x
set -e
set -o pipefail

$CLOJURE_VERSION=1.11.1.1208

curl -O https://download.clojure.org/install/linux-install-${CLOJURE_VERSION}.sh
chmod +x linux-install-${CLOJURE_VERSION}.sh
sudo ./linux-install-${CLOJURE_VERSION}.sh
