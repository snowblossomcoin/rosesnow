FROM ubuntu:20.10

ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update
RUN apt-get install --yes curl vim

RUN curl -sSfL https://raw.githubusercontent.com/coinbase/rosetta-cli/master/scripts/install.sh | sh -s

COPY . /snowconfig
WORKDIR /snowconfig

CMD bash

#  docker run --rm -it --network host snowblossom/rosetta-cli

