# About

This is a single-step "Hello World" Spring Batch job to test the native performance of the core framework.

The application is based on Spring Boot.

# How to run the sample

### Prerequisites

* Java 17+
* GraalVM 22.3+

With [SDKMAN!](https://sdkman.io), those can be installed as follows:

```
$>sdk install java 22.3.r17-grl
$>sdk use java 22.3.r17-grl
$>java -version
openjdk version "17.0.5" 2022-10-18
OpenJDK Runtime Environment GraalVM CE 22.3.0 (build 17.0.5+8-jvmci-22.3-b08)
OpenJDK 64-Bit Server VM GraalVM CE 22.3.0 (build 17.0.5+8-jvmci-22.3-b08, mixed mode, sharing)
```

### Compile and run the Java app

```
$>./mvnw clean package
$>java -jar target/spring-batch-native-0.0.1-SNAPSHOT.jar
```

### Compile and run the Native app

```
$>./mvnw -Pnative clean native:compile
$>./target/spring-batch-native
```

# Results

### JVM app

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.6)

2023-05-16T10:40:59.991+02:00  INFO 2477 --- [           main] io.spring.SpringBatchNativeApp           : Starting SpringBatchNativeApp v0.0.1-SNAPSHOT using Java 17.0.2 with PID 2477 (/Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/hello-world/target/spring-batch-native-0.0.1-SNAPSHOT.jar started by mbenhassine in /Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/hello-world)
2023-05-16T10:40:59.994+02:00  INFO 2477 --- [           main] io.spring.SpringBatchNativeApp           : No active profile set, falling back to 1 default profile: "default"
2023-05-16T10:41:00.540+02:00  INFO 2477 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-05-16T10:41:00.725+02:00  INFO 2477 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:34b65098-2011-4a76-9c9c-b405ea6c00b0 user=SA
2023-05-16T10:41:00.726+02:00  INFO 2477 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-05-16T10:41:00.959+02:00  INFO 2477 --- [           main] io.spring.SpringBatchNativeApp           : Started SpringBatchNativeApp in 1.248 seconds (process running for 1.595)
2023-05-16T10:41:00.961+02:00  INFO 2477 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-05-16T10:41:00.998+02:00  INFO 2477 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=myJob]] launched with the following parameters: [{}]
2023-05-16T10:41:01.022+02:00  INFO 2477 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [myStep]
2023-05-16T10:41:01.031+02:00  INFO 2477 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [myStep] executed in 8ms
2023-05-16T10:41:01.038+02:00  INFO 2477 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=myJob]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 26ms
2023-05-16T10:41:01.041+02:00  INFO 2477 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-05-16T10:41:01.043+02:00  INFO 2477 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

### Native app

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.6)

2023-05-16T10:43:30.901+02:00  INFO 2660 --- [           main] io.spring.SpringBatchNativeApp           : Starting AOT-processed SpringBatchNativeApp using Java 17.0.5 with PID 2660 (/Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/hello-world/target/spring-batch-native started by mbenhassine in /Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/hello-world)
2023-05-16T10:43:30.901+02:00  INFO 2660 --- [           main] io.spring.SpringBatchNativeApp           : No active profile set, falling back to 1 default profile: "default"
2023-05-16T10:43:30.915+02:00  INFO 2660 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-05-16T10:43:30.918+02:00  INFO 2660 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:236aaf01-e7bf-4956-9baa-a50f325cead8 user=SA
2023-05-16T10:43:30.918+02:00  INFO 2660 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-05-16T10:43:30.934+02:00  INFO 2660 --- [           main] io.spring.SpringBatchNativeApp           : Started SpringBatchNativeApp in 0.044 seconds (process running for 0.056)
2023-05-16T10:43:30.934+02:00  INFO 2660 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-05-16T10:43:30.936+02:00  INFO 2660 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=myJob]] launched with the following parameters: [{}]
2023-05-16T10:43:30.937+02:00  INFO 2660 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [myStep]
2023-05-16T10:43:30.937+02:00  INFO 2660 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [myStep] executed in
2023-05-16T10:43:30.938+02:00  INFO 2660 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=myJob]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 1ms
2023-05-16T10:43:30.938+02:00  INFO 2660 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-05-16T10:43:30.938+02:00  INFO 2660 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
