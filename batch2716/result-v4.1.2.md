### First execution (19s)

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-07-09 10:15:41.715  INFO 19035 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on localhost with PID 19035 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2716/target/classes started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2716)
2019-07-09 10:15:41.717  INFO 19035 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-07-09 10:15:42.333  INFO 19035 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'threadPoolTaskExecutor'
2019-07-09 10:15:42.407  INFO 19035 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-07-09 10:15:42.459  INFO 19035 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-07-09 10:15:42.467  INFO 19035 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-07-09 10:15:42.521  INFO 19035 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-07-09 10:15:42.620  INFO 19035 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.13 seconds (JVM running for 1.638)
2019-07-09 10:15:42.621  INFO 19035 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: []
2019-07-09 10:15:42.689  INFO 19035 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=partitionJob]] launched with the following parameters: [{}]
2019-07-09 10:15:42.720  INFO 19035 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [masterStep]
2019-07-09 10:16:01.456  INFO 19035 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'threadPoolTaskExecutor'
2019-07-09 10:16:01.458  INFO 19035 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=partitionJob]] completed with the following parameters: [{}] and the following status: [COMPLETED]
2019-07-09 10:16:01.461  INFO 19035 --- [       Thread-1] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'threadPoolTaskExecutor'
2019-07-09 10:16:01.462  INFO 19035 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-07-09 10:16:01.468  INFO 19035 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

### Second execution (20min4s)

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-07-09 10:17:09.700  INFO 19054 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on localhost with PID 19054 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2716/target/classes started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2716)
2019-07-09 10:17:09.702  INFO 19054 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-07-09 10:17:10.358  INFO 19054 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'threadPoolTaskExecutor'
2019-07-09 10:17:10.441  INFO 19054 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-07-09 10:17:10.491  INFO 19054 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-07-09 10:17:10.499  INFO 19054 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-07-09 10:17:10.555  INFO 19054 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-07-09 10:17:10.669  INFO 19054 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.178 seconds (JVM running for 1.733)
2019-07-09 10:17:10.670  INFO 19054 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: []
2019-07-09 10:17:11.095  INFO 19054 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=partitionJob]] launched with the following parameters: [{}]
2019-07-09 10:17:11.389  INFO 19054 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [masterStep]
2019-07-09 10:37:15.653  INFO 19054 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'threadPoolTaskExecutor'
2019-07-09 10:37:15.655  INFO 19054 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=partitionJob]] completed with the following parameters: [{}] and the following status: [COMPLETED]
2019-07-09 10:37:15.659  INFO 19054 --- [       Thread-1] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'threadPoolTaskExecutor'
2019-07-09 10:37:15.659  INFO 19054 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-07-09 10:37:15.664  INFO 19054 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
