# Objective

This project is the Snowblossom implementation of the [Rosetta API](https://www.rosetta-api.org/)


## Setup source

Using swagger hub, import latest open api spec from Rosetta API.
Download server stub -> inflector

Smash the java code into bazel.  Everything else into maven.

Should only need to be one on major new changes to the API.

## Hack of Shame:

```
bazel build :all :RoseSnow_deploy.jar
cd maven
mvn package jetty:run
```
Ignore the 1000 pages of class files from multiple locations.
Hang head in shame.
Direct queries to localhost:8080.

The reason is, we want to use bazel to bring in Snowblossom libraries, including
node, client, gRPC, etc.  But I can't figure out how to start jetty other than
using the maven plugin (I'm sure this is my failing, but doing this hack for now).


