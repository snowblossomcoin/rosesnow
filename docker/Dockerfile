FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update
RUN apt-get install --yes curl gpg git apt-utils default-jdk maven
RUN echo "deb [arch=amd64] http://storage.googleapis.com/bazel-apt stable jdk1.8" > /etc/apt/sources.list.d/snowblossom-bazel.list
RUN curl https://bazel.build/bazel-release.pub.gpg | apt-key add -

RUN apt-get update
RUN apt-get install --yes bazel

RUN mkdir -p /var/build/snow
WORKDIR /var/build/snowblossom


# TODO - make this cleaner, probably involving tags
RUN git clone https://github.com/snowblossomcoin/rosesnow.git rosesnow.git
WORKDIR /var/build/snowblossom/rosesnow.git
RUN git pull && git checkout 1a5ee86c1eb16946011bdfb4d28ea6eaff6bb068 

RUN bazel build :RoseSnow_deploy.jar

WORKDIR /var/build/snowblossom/rosesnow.git/maven

EXPOSE 8080/tcp

RUN mvn package

CMD mvn jetty:run
# Run with:
#  docker run -p 8080:8080/tcp

