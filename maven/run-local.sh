#!/bin/bash

set -eu

rsync -avP ../bazel-bin/RoseSnow_deploy.jar local-maven-repo/rosesnow/base/1.0/base-1.0.jar

mvn clean 
rm -rf ~/.m2/repository/rosesnow 

mvn package jetty:run




