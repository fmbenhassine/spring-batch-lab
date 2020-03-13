# use multi-stage build to optimize final image size
FROM maven:3.6.3-jdk-8-slim AS build
WORKDIR /tmp
COPY src/* ./src/main/
COPY pom.xml ./
RUN mvn package dependency:copy-dependencies

FROM openjdk:8-jre-alpine
# use separate layers for app/dependencies to re-use cached layers
COPY --from=build /tmp/target/dependency/* /tmp/dependencies/
COPY --from=build /tmp/target/sbk-0.1.jar /tmp/job.jar
ENTRYPOINT [ "java", "-cp", "/tmp/dependencies/*:/tmp/job.jar", "org.springframework.batch.core.launch.support.CommandLineJobRunner", "io.github.benas.sbk.JobConfiguration", "job" ]
