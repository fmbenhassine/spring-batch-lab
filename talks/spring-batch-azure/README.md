# About this repository

This repository shows how to deploy a Spring Boot Batch application on Microsoft Azure with Azure Spring Apps.

The application is a single-step Spring Batch job that prints "Hello Azure World!" to the standard output.

# Pre-requisites

1. Install Azure CLI
2. Install Azure Spring extension
3. Login to Azure

# Build the application

```
$>mvn package
```

# Deploy the application to Azure

First create an Azure Spring App:

```
$>az spring app create \
    --resource-group <YOUR_RESOURCE_GROUP> \
    --service <YOUR_SERVICE_NAME> \
    --name spring-batch-app \
    --assign-endpoint false
```

Then deploy it to Azure:

```
$>az spring app deploy \
    --resource-group <YOUR_RESOURCE_GROUP> \
    --service <YOUR_SERVICE_NAME> \
    --name spring-batch-app \
    --artifact-path target/spring-batch-azure-0.0.1-SNAPSHOT.jar
```

You can check the application logs with the following command:

```
$>az spring app logs \
    --resource-group <YOUR_RESOURCE_GROUP> \
    --service <YOUR_SERVICE_NAME> \
    --name spring-batch-app
```

You should see something like the following output:

```
Build in Environment Variables
BUILD_IN_EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=https://<YOUR_SERVICE_NAME>.svc.azuremicroservices.io/eureka/eureka
BUILD_IN_SPRING_CLOUD_CONFIG_URI=https://<YOUR_SERVICE_NAME>.svc.azuremicroservices.io/config
BUILD_IN_SPRING_CLOUD_CONFIG_FAILFAST=true
[Azure Spring Cloud] The following environment variables are loaded:
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
2023-01-20 13:16:42.139Z INFO  c.m.applicationinsights.agent - Application Insights Java Agent 3.4.4 started successfully (PID 1, JVM running for 6.328 s)
2023-01-20 13:16:42.145Z INFO  c.m.applicationinsights.agent - Java version: 17.0.5, vendor: Microsoft, home: /usr/lib/jvm/msopenjdk-17

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.1)

2023-01-20T13:16:46.753Z  INFO 1 --- [           main] io.spring.SpringBatchAzureApp            : Starting SpringBatchAzureApp v0.0.1-SNAPSHOT using Java 17.0.5 with PID 1 (/tmp/c7a9bdc0-62fd-4333-b337-aa236a883055 started by cnb in /home/cnb)
2023-01-20T13:16:46.764Z  INFO 1 --- [           main] io.spring.SpringBatchAzureApp            : No active profile set, falling back to 1 default profile: "default"
2023-01-20T13:16:48.852Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-01-20T13:16:49.434Z  INFO 1 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:f3e87547-ccc4-4205-bbf1-73ba4800bf91 user=SA
2023-01-20T13:16:49.439Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-01-20T13:16:50.138Z  INFO 1 --- [           main] i.m.c.instrument.push.PushMeterRegistry  : publishing metrics for AzureMonitorMeterRegistry every 1m
2023-01-20T13:16:50.777Z  INFO 1 --- [           main] io.spring.SpringBatchAzureApp            : Started SpringBatchAzureApp in 5.727 seconds (process running for 14.967)
2023-01-20T13:16:50.779Z  INFO 1 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-01-20T13:16:51.052Z  INFO 1 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
2023-01-20T13:16:51.159Z  INFO 1 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
Hello Azure World!
2023-01-20T13:16:51.175Z  INFO 1 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step] executed in 15ms
2023-01-20T13:16:51.239Z  INFO 1 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 99ms
2023-01-20T13:16:51.250Z  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-01-20T13:16:51.256Z  INFO 1 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

# Feedback

What I really like about ASA is that it automatically prepared the following:

* A configuration server: `BUILD_IN_SPRING_CLOUD_CONFIG_URI=https://<YOUR_SERVICE_NAME>.svc.azuremicroservices.io/config`
* A service discovery server: `BUILD_IN_EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=https://<YOUR_SERVICE_NAME>.svc.azuremicroservices.io/eureka/eureka`
* A MS OpenJDK distribution: `home: /usr/lib/jvm/msopenjdk-17`
* A meter registry that pushes metrics to Azure: `i.m.c.instrument.push.PushMeterRegistry  : publishing metrics for AzureMonitorMeterRegistry every 1m`
* and many other things that are possible through the CLI and GUI!