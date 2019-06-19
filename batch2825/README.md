### Download h2 distribution and run it in server mode:

```
$> mbenhassine @ localhost in ~/tools/h2/bin [13:50:21] C:130
$> java -cp h2-1.4.199.jar org.h2.tools.Server -tcp -web -ifNotExists
TCP server running at tcp://localhost:9092 (only local connections)
Web Console server running at http://localhost:8082 (only local connections)
```

The database `test` (file `test.mv.db`) wil be automatically created in `~` when requested the first time.

### Result with boot 2.0.x

```
$ mbenhassine @ localhost in ~/projects/benas/spring-batch-sandbox/batch2825 on git:master x [10:00:49]
$ java -jar target/demo-0.0.1-SNAPSHOT.jar foo=bar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-06-12 10:01:14.141  INFO 26535 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication v0.0.1-SNAPSHOT on localhost with PID 26535 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825/target/demo-0.0.1-SNAPSHOT.jar started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825)
2019-06-12 10:01:14.144  INFO 26535 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-06-12 10:01:14.898  INFO 26535 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-06-12 10:01:15.078  INFO 26535 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-06-12 10:01:15.086  INFO 26535 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-06-12 10:01:15.246  INFO 26535 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-06-12 10:01:15.426  INFO 26535 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.596 seconds (JVM running for 1.953)
2019-06-12 10:01:15.428  INFO 26535 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: [foo=bar]
2019-06-12 10:01:15.523  INFO 26535 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{run.id=1, foo=bar}]
2019-06-12 10:01:15.557  INFO 26535 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
hello world
2019-06-12 10:01:15.584  INFO 26535 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{run.id=1, foo=bar}] and the following status: [COMPLETED]
2019-06-12 10:01:15.588  INFO 26535 --- [       Thread-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-06-12 10:01:15.805  INFO 26535 --- [       Thread-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

$ mbenhassine @ localhost in ~/projects/benas/spring-batch-sandbox/batch2825 on git:master x [10:01:15]
$ java -jar target/demo-0.0.1-SNAPSHOT.jar foo=baz

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-06-12 10:01:28.265  INFO 26551 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication v0.0.1-SNAPSHOT on localhost with PID 26551 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825/target/demo-0.0.1-SNAPSHOT.jar started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825)
2019-06-12 10:01:28.268  INFO 26551 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-06-12 10:01:29.211  INFO 26551 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-06-12 10:01:29.363  INFO 26551 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-06-12 10:01:29.375  INFO 26551 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-06-12 10:01:29.541  INFO 26551 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-06-12 10:01:29.696  INFO 26551 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.785 seconds (JVM running for 2.146)
2019-06-12 10:01:29.697  INFO 26551 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: [foo=baz]
2019-06-12 10:01:29.843  INFO 26551 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{run.id=2, foo=baz}]
2019-06-12 10:01:29.866  INFO 26551 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
hello world
2019-06-12 10:01:29.894  INFO 26551 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{run.id=2, foo=baz}] and the following status: [COMPLETED]
2019-06-12 10:01:29.899  INFO 26551 --- [       Thread-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-06-12 10:01:29.918  INFO 26551 --- [       Thread-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

$ mbenhassine @ localhost in ~/projects/benas/spring-batch-sandbox/batch2825 on git:master x [10:01:30]
$ java -jar target/demo-0.0.1-SNAPSHOT.jar baz=goo

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-06-12 10:01:56.457  INFO 26717 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication v0.0.1-SNAPSHOT on localhost with PID 26717 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825/target/demo-0.0.1-SNAPSHOT.jar started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825)
2019-06-12 10:01:56.459  INFO 26717 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-06-12 10:01:57.544  INFO 26717 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-06-12 10:01:57.709  INFO 26717 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-06-12 10:01:57.722  INFO 26717 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-06-12 10:01:57.907  INFO 26717 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-06-12 10:01:58.081  INFO 26717 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.979 seconds (JVM running for 2.355)
2019-06-12 10:01:58.083  INFO 26717 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: [baz=goo]
2019-06-12 10:01:58.224  INFO 26717 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{run.id=3, baz=goo, foo=baz}]
2019-06-12 10:01:58.247  INFO 26717 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
hello world
2019-06-12 10:01:58.274  INFO 26717 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{run.id=3, baz=goo, foo=baz}] and the following status: [COMPLETED]
2019-06-12 10:01:58.279  INFO 26717 --- [       Thread-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-06-12 10:01:58.494  INFO 26717 --- [       Thread-2] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

### Result with boot 1.5.x

```
# mbenhassine @ localhost in ~/projects/benas/spring-batch-sandbox/batch2825 on git:master x [10:59:45]
$ java -jar target/demo-0.0.1-SNAPSHOT.jar foo=bar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v1.5.21.RELEASE)

2019-06-19 10:59:54.939  INFO 92490 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication v0.0.1-SNAPSHOT on localhost with PID 92490 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825/target/demo-0.0.1-SNAPSHOT.jar started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825)
2019-06-19 10:59:54.943  INFO 92490 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-06-19 10:59:54.999  INFO 92490 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@255316f2: startup date [Wed Jun 19 10:59:54 CEST 2019]; root of context hierarchy
2019-06-19 10:59:56.188  INFO 92490 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executing SQL script from class path resource [org/springframework/batch/core/schema-h2.sql]
2019-06-19 10:59:56.254  INFO 92490 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executed SQL script from class path resource [org/springframework/batch/core/schema-h2.sql] in 66 ms.
2019-06-19 10:59:56.440  INFO 92490 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2019-06-19 10:59:56.454  INFO 92490 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: [foo=bar]
2019-06-19 10:59:56.473  INFO 92490 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-06-19 10:59:56.710  INFO 92490 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-06-19 10:59:56.822  INFO 92490 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{run.id=1, foo=bar}]
2019-06-19 10:59:56.854  INFO 92490 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
hello world
2019-06-19 10:59:56.883  INFO 92490 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{run.id=1, foo=bar}] and the following status: [COMPLETED]
2019-06-19 10:59:56.886  INFO 92490 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 2.301 seconds (JVM running for 2.723)
2019-06-19 10:59:56.887  INFO 92490 --- [       Thread-3] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@255316f2: startup date [Wed Jun 19 10:59:54 CEST 2019]; root of context hierarchy
2019-06-19 10:59:56.889  INFO 92490 --- [       Thread-3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown

# mbenhassine @ localhost in ~/projects/benas/spring-batch-sandbox/batch2825 on git:master x [10:59:57]
$ java -jar target/demo-0.0.1-SNAPSHOT.jar foo=baz

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v1.5.21.RELEASE)

2019-06-19 11:01:08.753  INFO 92510 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication v0.0.1-SNAPSHOT on localhost with PID 92510 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825/target/demo-0.0.1-SNAPSHOT.jar started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825)
2019-06-19 11:01:08.756  INFO 92510 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-06-19 11:01:08.821  INFO 92510 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@255316f2: startup date [Wed Jun 19 11:01:08 CEST 2019]; root of context hierarchy
2019-06-19 11:01:09.941  INFO 92510 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executing SQL script from class path resource [org/springframework/batch/core/schema-h2.sql]
2019-06-19 11:01:09.962  INFO 92510 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executed SQL script from class path resource [org/springframework/batch/core/schema-h2.sql] in 21 ms.
2019-06-19 11:01:10.135  INFO 92510 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2019-06-19 11:01:10.150  INFO 92510 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: [foo=baz]
2019-06-19 11:01:10.165  INFO 92510 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-06-19 11:01:10.386  INFO 92510 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
Security framework of XStream not initialized, XStream is probably vulnerable.
2019-06-19 11:01:10.518  INFO 92510 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{run.id=2, foo=baz}]
2019-06-19 11:01:10.542  INFO 92510 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
hello world
2019-06-19 11:01:10.575  INFO 92510 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{run.id=2, foo=baz}] and the following status: [COMPLETED]
2019-06-19 11:01:10.577  INFO 92510 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 2.18 seconds (JVM running for 2.555)
2019-06-19 11:01:10.578  INFO 92510 --- [       Thread-3] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@255316f2: startup date [Wed Jun 19 11:01:08 CEST 2019]; root of context hierarchy
2019-06-19 11:01:10.579  INFO 92510 --- [       Thread-3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown

# mbenhassine @ localhost in ~/projects/benas/spring-batch-sandbox/batch2825 on git:master x [11:01:10]
$ java -jar target/demo-0.0.1-SNAPSHOT.jar baz=goo

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v1.5.21.RELEASE)

2019-06-19 11:01:41.654  INFO 92526 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication v0.0.1-SNAPSHOT on localhost with PID 92526 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825/target/demo-0.0.1-SNAPSHOT.jar started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2825)
2019-06-19 11:01:41.657  INFO 92526 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-06-19 11:01:41.723  INFO 92526 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@255316f2: startup date [Wed Jun 19 11:01:41 CEST 2019]; root of context hierarchy
2019-06-19 11:01:42.841  INFO 92526 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executing SQL script from class path resource [org/springframework/batch/core/schema-h2.sql]
2019-06-19 11:01:42.861  INFO 92526 --- [           main] o.s.jdbc.datasource.init.ScriptUtils     : Executed SQL script from class path resource [org/springframework/batch/core/schema-h2.sql] in 19 ms.
2019-06-19 11:01:43.041  INFO 92526 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2019-06-19 11:01:43.060  INFO 92526 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: [baz=goo]
2019-06-19 11:01:43.074  INFO 92526 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-06-19 11:01:43.297  INFO 92526 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
Security framework of XStream not initialized, XStream is probably vulnerable.
2019-06-19 11:01:43.424  INFO 92526 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{run.id=3, baz=goo, foo=baz}]
2019-06-19 11:01:43.447  INFO 92526 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
hello world
2019-06-19 11:01:43.482  INFO 92526 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{run.id=3, baz=goo, foo=baz}] and the following status: [COMPLETED]
2019-06-19 11:01:43.485  INFO 92526 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 2.167 seconds (JVM running for 2.569)
2019-06-19 11:01:43.486  INFO 92526 --- [       Thread-3] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@255316f2: startup date [Wed Jun 19 11:01:41 CEST 2019]; root of context hierarchy
2019-06-19 11:01:43.487  INFO 92526 --- [       Thread-3] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
```
