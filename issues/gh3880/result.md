```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.4)

2021-04-14 15:54:39.765  INFO 74973 --- [           main] com.example.gh3880.Gh3880Application     : Starting Gh3880Application using Java 16 on mbenhassine-a01.vmware.com with PID 74973 (/Users/mbenhassine/Downloads/gh3880/target/classes started by mbenhassine in /Users/mbenhassine/Downloads/gh3880)
2021-04-14 15:54:39.767  INFO 74973 --- [           main] com.example.gh3880.Gh3880Application     : No active profile set, falling back to default profiles: default
2021-04-14 15:54:40.437  INFO 74973 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-04-14 15:54:40.554  INFO 74973 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-04-14 15:54:40.625  INFO 74973 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2021-04-14 15:54:40.736  INFO 74973 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2021-04-14 15:54:40.807  INFO 74973 --- [           main] com.example.gh3880.Gh3880Application     : Started Gh3880Application in 1.409 seconds (JVM running for 2.601)
2021-04-14 15:54:40.809  INFO 74973 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2021-04-14 15:54:40.866  INFO 74973 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
2021-04-14 15:54:40.908  INFO 74973 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
LogStepExecutionListener.beforeStep
LogChunkListener.beforeChunk
ItemReadLogListener.beforeRead
ItemReadLogListener.afterRead 1
ItemReadLogListener.beforeRead
ItemReadLogListener.afterRead 2
ItemProcessLogListener.beforeProcess 1
ItemProcessLogListener.afterProcess 1 |foo1
ItemProcessLogListener.beforeProcess 2
ItemProcessLogListener.afterProcess 2 |foo2
ItemWriteLogListener.beforeWrite[foo1, foo2]
foo1
foo2
ItemWriteLogListener.afterWrite[foo1, foo2]
LogChunkListener.afterChunk
LogChunkListener.beforeChunk
ItemReadLogListener.beforeRead
ItemReadLogListener.afterRead 3
ItemReadLogListener.beforeRead
ItemReadLogListener.afterRead 4
ItemProcessLogListener.beforeProcess 3
ItemProcessLogListener.afterProcess 3 |foo3
ItemProcessLogListener.beforeProcess 4
ItemProcessLogListener.afterProcess 4 |foo4
ItemWriteLogListener.beforeWrite[foo3, foo4]
foo3
foo4
ItemWriteLogListener.afterWrite[foo3, foo4]
LogChunkListener.afterChunk
LogChunkListener.beforeChunk
ItemReadLogListener.beforeRead
LogChunkListener.afterChunk
2021-04-14 15:54:40.927  INFO 74973 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step] executed in 18ms
2021-04-14 15:54:40.931  INFO 74973 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 37ms
2021-04-14 15:54:40.935  INFO 74973 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2021-04-14 15:54:40.937  INFO 74973 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```