# About

This is a single-step Spring Batch job that reads data from a flat file and loads it in a relational database.

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


### Generate the input file

```
$>for i in {1..1000000}; do echo "$i,foo$i" >> persons.csv; done
```

### Compile and run the Java app

```
$>./mvnw clean package
$>java -jar target/spring-batch-native-0.0.1-SNAPSHOT.jar fileName=persons.csv
```

### Compile and run the Native app

```
$>./mvnw -Pnative clean native:compile
$>./target/spring-batch-native fileName=persons.csv
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
 :: Spring Boot ::                (v3.0.2)

2023-02-06T12:28:45.610+01:00  INFO 69684 --- [           main] io.spring.SpringBatchNativeApp           : Starting SpringBatchNativeApp using Java 17 with PID 69684 (/Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/target/classes started by mbenhassine in /Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native)
2023-02-06T12:28:45.613+01:00  INFO 69684 --- [           main] io.spring.SpringBatchNativeApp           : No active profile set, falling back to 1 default profile: "default"
2023-02-06T12:28:45.992+01:00  INFO 69684 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-02-06T12:28:46.101+01:00  INFO 69684 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:50af4e66-aef6-46fe-9ee9-60a63272b938 user=SA
2023-02-06T12:28:46.102+01:00  INFO 69684 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-02-06T12:28:46.275+01:00  INFO 69684 --- [           main] io.spring.SpringBatchNativeApp           : Started SpringBatchNativeApp in 0.905 seconds (process running for 1.264)
2023-02-06T12:28:46.276+01:00  INFO 69684 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: [fileName=persons.csv]
2023-02-06T12:28:46.299+01:00  INFO 69684 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=myJob]] launched with the following parameters: [{'fileName':'{value=persons.csv, type=class java.lang.String, identifying=true}'}]
2023-02-06T12:28:46.312+01:00  INFO 69684 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [myStep]
2023-02-06T12:29:23.782+01:00  INFO 69684 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [myStep] executed in 37s469ms
2023-02-06T12:29:23.785+01:00  INFO 69684 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=myJob]] completed with the following parameters: [{'fileName':'{value=persons.csv, type=class java.lang.String, identifying=true}'}] and the following status: [COMPLETED] in 37s479ms
Number of persons in db = 1000000
2023-02-06T12:29:23.789+01:00  INFO 69684 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-02-06T12:29:23.790+01:00  INFO 69684 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

### Native app

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.2)

2023-02-06T13:35:40.194+01:00  INFO 77063 --- [           main] io.spring.SpringBatchNativeApp           : Starting AOT-processed SpringBatchNativeApp using Java 17.0.5 with PID 77063 (/Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/target/spring-batch-native started by mbenhassine in /Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native)
2023-02-06T13:35:40.194+01:00  INFO 77063 --- [           main] io.spring.SpringBatchNativeApp           : No active profile set, falling back to 1 default profile: "default"
2023-02-06T13:35:40.208+01:00  INFO 77063 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-02-06T13:35:40.211+01:00  INFO 77063 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:252c3c45-0186-4a94-bdac-cacbf3d164cb user=SA
2023-02-06T13:35:40.211+01:00  INFO 77063 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-02-06T13:35:40.224+01:00  INFO 77063 --- [           main] io.spring.SpringBatchNativeApp           : Started SpringBatchNativeApp in 0.041 seconds (process running for 0.051)
2023-02-06T13:35:40.224+01:00  INFO 77063 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: [fileName=/Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/persons.csv]
2023-02-06T13:35:40.226+01:00  INFO 77063 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=myJob]] launched with the following parameters: [{'fileName':'{value=/Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/persons.csv, type=class java.lang.String, identifying=true}'}]
2023-02-06T13:35:40.227+01:00  INFO 77063 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [myStep]
2023-02-06T13:35:55.375+01:00  INFO 77063 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [myStep] executed in 15s148ms
2023-02-06T13:35:55.375+01:00  INFO 77063 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=myJob]] completed with the following parameters: [{'fileName':'{value=/Users/mbenhassine/projects/spring-batch-lab/talks/spring-batch-native/persons.csv, type=class java.lang.String, identifying=true}'}] and the following status: [COMPLETED] in 15s149ms
Number of persons in db = 1000000
2023-02-06T13:35:55.376+01:00  INFO 77063 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-02-06T13:35:55.376+01:00  INFO 77063 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
