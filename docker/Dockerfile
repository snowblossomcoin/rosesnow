FROM ubuntu:20.04 as build

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

RUN useradd -ms /bin/bash snowblossom
RUN chown -R snowblossom:snowblossom /home/snowblossom

USER snowblossom
WORKDIR /home/snowblossom
RUN mkdir /home/snowblossom/rosesnow

WORKDIR /home/snowblossom/rosesnow
ARG REFSPEC=v0.4
RUN git init . \
  && git remote add origin https://github.com/snowblossomcoin/rosesnow.git \
  && git fetch origin ${REFSPEC} \
  && git checkout FETCH_HEAD \
  && rm -rf .git/

RUN bazel build :RoseSnow_deploy.jar
RUN cp bazel-bin/RoseSnow_deploy.jar maven/local-maven-repo/rosesnow/base/1.0/base-1.0.jar

WORKDIR /home/snowblossom/rosesnow/maven
RUN mvn package

FROM ubuntu:20.04 as runtime

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get update -qq \
  && apt-get install -qq --no-install-recommends --no-install-suggests \
    jetty9 \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/*

RUN rm -rf /var/lib/jetty9/webapps/root/
COPY --from=build /home/snowblossom/rosesnow/maven/target/snowrosetta-rosesnow.war \
  /var/lib/jetty9/webapps/ROOT.war

RUN chown -R jetty:adm /var/lib/jetty9/
RUN mkdir -p /data/snowblossom
RUN chown -R jetty /data/snowblossom

USER jetty

ENV JETTY_HOME=/usr/share/jetty9/
ENV JETTY_STATE=/var/lib/jetty9/jetty.state
ENV JAVA_OPTS=-Djava.awt.headless=true

EXPOSE 8080

CMD /usr/share/jetty9/bin/jetty.sh run

# To build and run any branch or tag:
# docker build --build-arg REFSPEC=main -t rosesnow-rosetta:dev .
# or
# docker build --build-arg REFSPEC=$(git rev-parse HEAD) -t rosesnow-rosetta:dev .
#
# docker run -it --rm -p --network host rosesnow-rosetta:dev
