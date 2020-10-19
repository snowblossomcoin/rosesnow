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

java_binary(
  name = "RoseSnow",
  main_class = "org.snowblossom.RoseSnow",
  runtime_deps = [
    ":rosesnowlib",
  ],
)

java_binary(
  name = "JettyRun",
  main_class = "org.eclipse.jetty.runner.Runner",
  runtime_deps = [
    "@maven//:org_eclipse_jetty_jetty_runner"
  ],
)


