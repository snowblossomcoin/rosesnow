FROM ubuntu:20.04

ARG DEBIAN_FRONTEND=noninteractive
ARG APT_KEY_DONT_WARN_ON_DANGEROUS_USAGE=true

RUN apt-get update -qq \
  && apt-get install -qq --no-install-recommends --no-install-suggests \
    apt-utils \
    gpg \
    gpg-agent \
    ca-certificates \
    curl

RUN echo "deb [arch=amd64] http://storage.googleapis.com/bazel-apt stable jdk1.8" \
  > /etc/apt/sources.list.d/snowblossom-bazel.list
RUN curl -Ls https://bazel.build/bazel-release.pub.gpg | apt-key add -

RUN apt-get update -qq \
  && apt-get install -qq --no-install-recommends --no-install-suggests \
    git \
    default-jdk-headless \
    bazel \
    maven \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /var/build/snow
WORKDIR /var/build/snowblossom

RUN git clone https://github.com/snowblossomcoin/rosesnow.git -b v0.1 rosesnow.git

WORKDIR /var/build/snowblossom/rosesnow.git
RUN bazel build :RoseSnow_deploy.jar

WORKDIR /var/build/snowblossom/rosesnow.git/maven

EXPOSE 8080/tcp

RUN mvn package

CMD mvn jetty:run
# Run with:
#  docker run -p 8080:8080/tcp

