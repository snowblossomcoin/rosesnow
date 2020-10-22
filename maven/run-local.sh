#!/bin/bash

rsync -avP ../bazel-bin/RoseSnow_deploy.jar local-maven-repo/rosesnow/base/1.0/base-1.0.jar

mvn package jetty:run


