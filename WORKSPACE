load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

git_repository(
    name = "rules_jvm_external",
    remote = "https://github.com/bazelbuild/rules_jvm_external",
    commit = "9aec21a7eff032dfbdcf728bb608fe1a02c54124",
    shallow_since = "1577467222 -0500"
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

git_repository(
  name = "build_stack_rules_proto",
  remote = "https://github.com/fireduck64/rules_proto",
	commit = "8ab7bf0c7c992c893813f7151af4794ec5dd3e3f", 
  shallow_since = "1579669787 -0800"
)

load("@build_stack_rules_proto//:deps.bzl", "io_grpc_grpc_java")
load("@build_stack_rules_proto//java:deps.bzl", "java_proto_compile")

io_grpc_grpc_java()
java_proto_compile()

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

load("@build_stack_rules_proto//java:deps.bzl", "java_grpc_library")

java_grpc_library()

maven_install(
    artifacts = [
        "com.google.protobuf:protobuf-java:3.5.1",
        "org.rocksdb:rocksdbjni:7.3.1",
        "junit:junit:4.12",
        "commons-codec:commons-codec:1.11",
        "org.apache.commons:commons-math3:3.6.1",
        "io.netty:netty-tcnative-boringssl-static:2.0.28.Final",
        "org.bouncycastle:bcprov-jdk15on:1.69",
        "org.bouncycastle:bcpkix-jdk15on:1.69",
        "org.bouncycastle:bcprov-jdk15to18:1.69",
        "com.thetransactioncompany:jsonrpc2-server:1.11",
        "net.minidev:json-smart:2.4.7",
        "com.lambdaworks:scrypt:1.4.0",
        "com.google.zxing:javase:3.4.0",
        "org.bitcoinj:bitcoinj-core:0.15.10",
  			"org.bitlet:weupnp:0.1.4",
        "io.netty:netty-handler:4.1.34.Final",
        "io.swagger:swagger-inflector:2.0.5",
        "org.eclipse.jetty:jetty-runner:9.4.32.v20200930",
        "org.slf4j:slf4j-api:1.7.30",
        "org.slf4j:slf4j-ext:1.7.30",
        "org.slf4j:slf4j-nop:1.7.30",
        "ch.qos.logback:logback-classic:1.2.3",
        "ch.qos.logback:logback-core:1.2.3",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
        "https://maven.google.com",
    ],
    #maven_install_json = "//:maven_install.json",
)
# After updating run:
# 
# bazel run @unpinned_maven//:pin
#
# See: https://github.com/bazelbuild/rules_jvm_external

load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()

git_repository(
  name = "snowblossom",
  remote = "https://github.com/snowblossomcoin/snowblossom",
	commit = "b6848352d45ba035bd37abbcbdf41b34017b4fcb",
  shallow_since = "1595994852 -0700"
)

git_repository(
  name = "duckutil",
  remote = "https://github.com/fireduck64/duckutil",
  commit = "b721d945278dc2069bb9f5c1556161b37d6b4ee8",
  shallow_since = "1576867546 -0800",
)


