### Batch metrics with Micrometer, Prometheus and Grafana

This sample shows how to use [Micrometer](https://micrometer.io) to collect batch metrics in Spring Batch.
It uses [Prometheus](https://prometheus.io) as metrics backend and [Grafana](https://grafana.com) as frontend.
The sample consists of two jobs:

* `job1` : Composed of two tasklets that print `hello` and `world` to the standard output.
* `job2` : Composed of single chunk-oriented step that reads a random number of items from memory and writes to the standard output.

These two jobs are run repeatedly at regular intervals and might fail randomly for demonstration purposes.

This sample requires [docker compose](https://docs.docker.com/compose/) to start the monitoring stack.
To run the sample, please follow these steps:

```
$>cd spring-batch-metrics/src/docker
$>docker-compose up -d
```

This should start the required monitoring stack as follows:

* Prometheus server on port `9090`
* Prometheus push gateway on port `9091`
* Grafana on port `3000`

Once started, you need to [configure Prometheus as data source in Grafana](https://grafana.com/docs/features/datasources/prometheus/)
and import the ready-to-use dashboard in `spring-batch-metrics/src/docker/grafana/spring-batch-dashboard.json`.

Finally, run the `io.spring.DemoApplication` class without any argument to start the sample.

### Batch tracing with Spring Cloud Sleuth and Zipkin

This sample shows how to trace Spring Batch jobs with [Spring Cloud Sleuth](https://cloud.spring.io/spring-cloud-sleuth) and [Zipkin](https://zipkin.io).

The sample consists of a single job with two steps printing `hello` and `world` to the standard output.
The expected result is that a trace is created for the entire job with a span for each step.

This sample requires [docker compose](https://docs.docker.com/compose/) to start the tracing stack.
To run the sample, please follow these steps:

```
$>cd spring-batch-tracing/src/docker
$>docker-compose up -d
```

This should start the required tracing stack as follows:

* Zipkin server on port `9411`

Once started, you can browse the Zipkin's UI at `http://localhost:9411/zipkin/`.

Finally, run the `io.spring.DemoApplication` class without any argument to start the sample. Tracing data should
be available on Zipkin.