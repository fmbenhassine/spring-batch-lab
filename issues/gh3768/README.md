#### 1. Make sure to use GraalVM

```
$ java -version
openjdk version "11.0.8" 2020-07-14
OpenJDK Runtime Environment GraalVM CE 20.2.0 (build 11.0.8+10-jvmci-20.2-b03)
OpenJDK 64-Bit Server VM GraalVM CE 20.2.0 (build 11.0.8+10-jvmci-20.2-b03, mixed mode, sharing)
```

#### 2. Package the app

```
$ mvn clean package
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ demo ---
[INFO] Deleting /Users/mbenhassine/Downloads/demo/target
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ demo ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /Users/mbenhassine/Downloads/demo/target/classes
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/mbenhassine/Downloads/demo/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ demo ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ demo ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:3.2.0:jar (default-jar) @ demo ---
[INFO] Building jar: /Users/mbenhassine/Downloads/demo/target/demo-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.3.3.RELEASE:repackage (repackage) @ demo ---
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.889 s
[INFO] Finished at: 2020-09-08T09:10:54+02:00
[INFO] ------------------------------------------------------------------------
```

#### 3. Run the app

```
$ java -jar target/demo-0.0.1-SNAPSHOT.jar name=foo

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.3.RELEASE)

2020-09-08 09:10:59.747  INFO 58325 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication v0.0.1-SNAPSHOT on localhost with PID 58325 (/Users/mbenhassine/Downloads/demo/target/demo-0.0.1-SNAPSHOT.jar started by mbenhassine in /Users/mbenhassine/Downloads/demo)
2020-09-08 09:10:59.750  INFO 58325 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2020-09-08 09:11:00.820  WARN 58325 --- [           main] o.s.b.c.l.AbstractListenerFactoryBean    : org.springframework.batch.item.ItemReader is an interface. The implementing class will not be queried for annotation based listener configurations. If using @StepScope on a @Bean method, be sure to return the implementing class so listener annotations can be used.
2020-09-08 09:11:00.824  WARN 58325 --- [           main] o.s.b.c.l.AbstractListenerFactoryBean    : org.springframework.batch.item.ItemWriter is an interface. The implementing class will not be queried for annotation based listener configurations. If using @StepScope on a @Bean method, be sure to return the implementing class so listener annotations can be used.
2020-09-08 09:11:00.824  WARN 58325 --- [           main] o.s.b.c.l.AbstractListenerFactoryBean    : org.springframework.batch.item.ItemProcessor is an interface. The implementing class will not be queried for annotation based listener configurations. If using @StepScope on a @Bean method, be sure to return the implementing class so listener annotations can be used.
2020-09-08 09:11:00.878  INFO 58325 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-09-08 09:11:01.163  INFO 58325 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-09-08 09:11:01.288  INFO 58325 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2020-09-08 09:11:01.470  INFO 58325 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2020-09-08 09:11:01.588  INFO 58325 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 2.314 seconds (JVM running for 2.795)
2020-09-08 09:11:01.591  INFO 58325 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: [name=foo]
2020-09-08 09:11:01.663  INFO 58325 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{name=foo}]
2020-09-08 09:11:01.712  INFO 58325 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step1]
hello foo
2020-09-08 09:11:01.765  INFO 58325 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step1] executed in 52ms
2020-09-08 09:11:01.771  INFO 58325 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step2]
item = 1
item = 2
item = 3
item = 4
item = 5
item = 6
item = 7
item = 8
item = 9
item = 10
2020-09-08 09:11:01.789  INFO 58325 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step2] executed in 18ms
2020-09-08 09:11:01.796  INFO 58325 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{name=foo}] and the following status: [COMPLETED] in 101ms
2020-09-08 09:11:01.801  INFO 58325 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2020-09-08 09:11:01.808  INFO 58325 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```