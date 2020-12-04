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

## Configuration

The package is intended to take no configuration.
All data is stored in /data/snowblossom (as per Rosetta API expectations).

Testnet vs Mainnet and Online vs Offline are all controlled by which APIs are called.

If you call an API that requests the node to be running, the node will be started.
So if you call only offline APIs, the no node will be started.

If you call /network/status on both mainnet and testnet, then both mainnet and testnet nodes
will be running for the duration of the process.  It is fine to run both on the same instance.
Not that I think that is likely to be required, but whatever.

The downside is that you can't just start it up and wait for it to sync.  You need to call something
to get it going get the node started.  However, my guess is that integrations will poll /network/status
for an online node so it should work fine.


# Updates
import into swaggerhub
https://raw.githubusercontent.com/coinbase/rosetta-specifications/master/api.json

export server -> inflector
unzip

copy openapi3.yaml ./src/main/resources/openapi.yaml
copy inflector.yaml ./src/main/resources/inflector.yaml
replace swaggerUrl: openapi.yaml

rsync src/gen to src/gen

Manually fix things in controller

# Docker

There is a basic Dockerfile in the top directory.  It builds the current repo.

There is a dockerfile compliant with the Rosetta API expectations in the "docker" directory.

If you want the auto built one it is at:
    
    docker pull snowblossom/rosetta:latest

# CLI

There are CLI scripts, test configs and a docker file.

If you want the built one it is at:
    
    docker pull snowblossom/rosetta-cli:latest

## Release Notes

### v0.4 - API version 1.4.8

Construction and data checks are passing.  The fees are being set correctly.



