### Download h2 distribution and run it in server mode:

```
$> mbenhassine @ localhost in ~/tools/h2/bin [13:50:21] C:130
$> java -cp h2-1.4.199.jar org.h2.tools.Server -tcp -web -ifNotExists
TCP server running at tcp://localhost:9092 (only local connections)
Web Console server running at http://localhost:8082 (only local connections)
```

The database `test` (file `test.mv.db`) wil be automatically created in `~` when requested the first time.

### Result

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
