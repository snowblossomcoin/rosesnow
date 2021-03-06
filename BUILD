package(default_visibility = ["//visibility:public"])

java_library(
  name = "rosesnowlib",
  srcs = glob(["src/**/*.java", "src/*.java"]),
  deps = [
    "@snowblossom//client:client",
    "@snowblossom//lib:lib",
    "@snowblossom//lib:rocksdb",
    "@snowblossom//node",
    "@snowblossom//protolib:protogrpc",
    "@duckutil//:duckutil_lib",
    "@duckutil//:webserver_lib",
    "@duckutil//:duckutil_jsonrpc_lib",
    "@javax_annotation_javax_annotation_api//:javax_annotation_javax_annotation_api",
    "@com_google_protobuf//:protobuf_java_util",
    "@maven//:junit_junit",
    "@maven//:net_minidev_json_smart",
    "@maven//:org_bouncycastle_bcpkix_jdk15on",
    "@maven//:org_bouncycastle_bcprov_jdk15on",
    "@maven//:org_bitlet_weupnp",
    "@maven//:io_netty_netty_handler",
    "@maven//:io_swagger_core_v3_swagger_core",
    "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    "@maven//:io_swagger_core_v3_swagger_annotations",
    "@maven//:io_swagger_swagger_inflector",
    "@maven//:javax_ws_rs_javax_ws_rs_api",
    "@maven//:org_glassfish_jersey_media_jersey_media_multipart",
    "@maven//:com_fasterxml_jackson_core_jackson_databind",
  ],
)

# Doesn't create a real runnable binary
# just used to make a single jar file for
# inclusion in maven
java_binary(
  name = "RoseSnow",
  main_class = "org.snowblossom.RoseSnow",
  runtime_deps = [
		":rosesnowlib",
  ],
)

java_library(
  name = "rosesnowtestlib",
  srcs = glob(["test/**/*.java", "test/*.java"]),
  deps = [
    ":rosesnowlib",
    "@snowblossom//lib",
    "@snowblossom//protolib:protogrpc",
    "@maven//:com_fasterxml_jackson_core_jackson_databind",
    "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    "@maven//:junit_junit",
    "@maven//:org_bouncycastle_bcpkix_jdk15on",
    "@maven//:org_bouncycastle_bcprov_jdk15on",
  ],
)

java_binary(
  name = "TestConstructionE2E",
  main_class = "org.snowblossom.rosesnow.test.ConstructionE2E",
  runtime_deps = [
    ":rosesnowtestlib",
  ],
)


java_test(
    name = "test_sig_coding",
    srcs = ["test/unit/TestSigCoding.java"],
    test_class = "TestSigCoding",
    size="small",
    deps = [
      ":rosesnowlib",
    	":rosesnowtestlib",
      "@com_google_protobuf//:protobuf_java",
      "@snowblossom//lib",
      "@snowblossom//protolib:protogrpc",
      "@maven//:org_bouncycastle_bcpkix_jdk15on",
      "@maven//:org_bouncycastle_bcprov_jdk15on",
    ],
)

