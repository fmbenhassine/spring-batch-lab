### 1. First execution (10s, that's ok since the db is empty)

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-09-11 16:47:33.209  INFO 49333 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on localhost with PID 49333 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2716/target/classes started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2716)
2019-09-11 16:47:33.211  INFO 49333 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-09-11 16:47:33.777  INFO 49333 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'threadPoolTaskExecutor'
2019-09-11 16:47:33.856  INFO 49333 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-09-11 16:47:33.909  INFO 49333 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-09-11 16:47:33.916  INFO 49333 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-09-11 16:47:33.970  INFO 49333 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-09-11 16:47:34.070  INFO 49333 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.053 seconds (JVM running for 1.578)
2019-09-11 16:47:34.071  INFO 49333 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: []
2019-09-11 16:47:34.147  INFO 49333 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=partitionJob]] launched with the following parameters: [{}]
2019-09-11 16:47:34.180  INFO 49333 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [masterStep]
2019-09-11 16:47:44.918  INFO 49333 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'threadPoolTaskExecutor'
2019-09-11 16:47:44.920  INFO 49333 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=partitionJob]] completed with the following parameters: [{}] and the following status: [COMPLETED]
2019-09-11 16:47:44.923  INFO 49333 --- [       Thread-1] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'threadPoolTaskExecutor'
2019-09-11 16:47:44.923  INFO 49333 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-09-11 16:47:44.929  INFO 49333 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

### 2. Second execution (4m18s = 258s 😱)

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-09-11 16:48:27.853  INFO 49910 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on localhost with PID 49910 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2716/target/classes started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/batch2716)
2019-09-11 16:48:27.855  INFO 49910 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-09-11 16:48:28.461  INFO 49910 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'threadPoolTaskExecutor'
2019-09-11 16:48:28.523  INFO 49910 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-09-11 16:48:28.571  INFO 49910 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-09-11 16:48:28.578  INFO 49910 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-09-11 16:48:28.630  INFO 49910 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-09-11 16:48:28.709  INFO 49910 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.129 seconds (JVM running for 1.775)
2019-09-11 16:48:28.710  INFO 49910 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: []
2019-09-11 16:48:28.980  INFO 49910 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=partitionJob]] launched with the following parameters: [{}]
2019-09-11 16:48:29.145  INFO 49910 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [masterStep]
2019-09-11 16:53:47.617  INFO 49910 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'threadPoolTaskExecutor'
2019-09-11 16:53:47.619  INFO 49910 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=partitionJob]] completed with the following parameters: [{}] and the following status: [COMPLETED]
2019-09-11 16:53:47.622  INFO 49910 --- [       Thread-1] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'threadPoolTaskExecutor'
2019-09-11 16:53:47.623  INFO 49910 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-09-11 16:53:47.626  INFO 49910 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
