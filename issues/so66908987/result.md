```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.4)

2021-04-02 14:37:31.152  INFO 90118 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 16 on mbenhassine-a01.vmware.com with PID 90118 (/Users/mbenhassine/Downloads/demo/target/classes started by mbenhassine in /Users/mbenhassine/Downloads/demo)
2021-04-02 14:37:31.155  INFO 90118 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2021-04-02 14:37:31.975  INFO 90118 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-04-02 14:37:32.037  INFO 90118 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-04-02 14:37:32.092  INFO 90118 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2021-04-02 14:37:32.151  INFO 90118 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2021-04-02 14:37:32.233  INFO 90118 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.345 seconds (JVM running for 1.969)
2021-04-02 14:37:32.236  INFO 90118 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: [files=classpath:*.txt]
2021-04-02 14:37:32.282  INFO 90118 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{files=classpath:*.txt}]
2021-04-02 14:37:32.306  INFO 90118 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
skipping line 'bar header' coming from bar.txt
skipping line 'foo header' coming from foo.txt
bar1
bar2
foo1
foo2
2021-04-02 14:37:32.340  INFO 90118 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step] executed in 34ms
2021-04-02 14:37:32.343  INFO 90118 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{files=classpath:*.txt}] and the following status: [COMPLETED] in 49ms
2021-04-02 14:37:32.347  INFO 90118 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2021-04-02 14:37:32.349  INFO 90118 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```