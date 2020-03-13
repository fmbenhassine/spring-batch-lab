## Result

The tasklet started at `11:25:30` and timed out at `11:25:40` (See `Transaction timed out: deadline was Thu Jul 25 11:25:40 CEST 2019`).
This means the overridden timeout value of 10s is taken into account
 (and takes precedence over the default value of 5s configured at the transaction manager level).


```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.0.RELEASE)

2019-07-25 11:25:29.619  INFO 63306 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on localhost with PID 63306 (/Users/mbenhassine/projects/benas/spring-batch-sandbox/so57191171/target/classes started by mbenhassine in /Users/mbenhassine/projects/benas/spring-batch-sandbox/so57191171)
2019-07-25 11:25:29.622  INFO 63306 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-07-25 11:25:30.257  INFO 63306 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-07-25 11:25:30.308  INFO 63306 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-07-25 11:25:30.314  INFO 63306 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2019-07-25 11:25:30.363  INFO 63306 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2019-07-25 11:25:30.484  INFO 63306 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.087 seconds (JVM running for 1.639)
2019-07-25 11:25:30.485  INFO 63306 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: []
2019-07-25 11:25:30.517  INFO 63306 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
2019-07-25 11:25:30.528  INFO 63306 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
2019-07-25T11:25:30.538803 hello world
2019-07-25 11:25:50.546 ERROR 63306 --- [           main] o.s.batch.core.step.tasklet.TaskletStep  : JobRepository failure forcing rollback

org.springframework.transaction.TransactionTimedOutException: Transaction timed out: deadline was Thu Jul 25 11:25:40 CEST 2019
	at org.springframework.transaction.support.ResourceHolderSupport.checkTransactionTimeout(ResourceHolderSupport.java:155) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.transaction.support.ResourceHolderSupport.getTimeToLiveInMillis(ResourceHolderSupport.java:144) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.transaction.support.ResourceHolderSupport.getTimeToLiveInSeconds(ResourceHolderSupport.java:128) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.datasource.DataSourceUtils.applyTimeout(DataSourceUtils.java:288) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.core.JdbcTemplate.applyStatementSettings(JdbcTemplate.java:1343) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:616) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.core.JdbcTemplate.update(JdbcTemplate.java:862) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.core.JdbcTemplate.update(JdbcTemplate.java:917) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.repository.dao.JdbcExecutionContextDao.persistSerializedContext(JdbcExecutionContextDao.java:233) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.repository.dao.JdbcExecutionContextDao.updateExecutionContext(JdbcExecutionContextDao.java:161) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext(SimpleJobRepository.java:211) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:343) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:294) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:98) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at com.sun.proxy.$Proxy38.updateExecutionContext(Unknown Source) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:343) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$PassthruAdvice.invoke(SimpleBatchConfiguration.java:127) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at com.sun.proxy.$Proxy38.updateExecutionContext(Unknown Source) ~[na:na]
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:452) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:331) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:273) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIteration(StepContextRepeatCallback.java:82) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.repeat.support.RepeatTemplate.getNextResult(RepeatTemplate.java:375) ~[spring-batch-infrastructure-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.repeat.support.RepeatTemplate.executeInternal(RepeatTemplate.java:215) ~[spring-batch-infrastructure-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.repeat.support.RepeatTemplate.iterate(RepeatTemplate.java:145) ~[spring-batch-infrastructure-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.step.tasklet.TaskletStep.doExecute(TaskletStep.java:258) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.step.AbstractStep.execute(AbstractStep.java:203) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.job.SimpleStepHandler.handleStep(SimpleStepHandler.java:148) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.job.AbstractJob.handleStep(AbstractJob.java:399) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.job.SimpleJob.doExecute(SimpleJob.java:135) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.job.AbstractJob.execute(AbstractJob.java:313) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.launch.support.SimpleJobLauncher$1.run(SimpleJobLauncher.java:144) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.core.task.SyncTaskExecutor.execute(SyncTaskExecutor.java:50) ~[spring-core-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.launch.support.SimpleJobLauncher.run(SimpleJobLauncher.java:137) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:343) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$PassthruAdvice.invoke(SimpleBatchConfiguration.java:127) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at com.sun.proxy.$Proxy41.run(Unknown Source) ~[na:na]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.execute(JobLauncherCommandLineRunner.java:214) ~[spring-boot-autoconfigure-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.executeLocalJobs(JobLauncherCommandLineRunner.java:186) ~[spring-boot-autoconfigure-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.launchJobFromProperties(JobLauncherCommandLineRunner.java:172) ~[spring-boot-autoconfigure-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.run(JobLauncherCommandLineRunner.java:166) ~[spring-boot-autoconfigure-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:813) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:797) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:324) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at com.example.demo.DemoApplication.main(DemoApplication.java:12) ~[classes/:na]

2019-07-25 11:25:50.547  INFO 63306 --- [           main] o.s.batch.core.step.tasklet.TaskletStep  : Commit failed while step execution data was already updated. Reverting to old version.
2019-07-25 11:25:50.549 ERROR 63306 --- [           main] o.s.batch.core.step.AbstractStep         : Encountered an error executing step step in job job

org.springframework.batch.core.step.FatalStepExecutionException: JobRepository failure forcing rollback
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:464) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:331) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:273) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIteration(StepContextRepeatCallback.java:82) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.repeat.support.RepeatTemplate.getNextResult(RepeatTemplate.java:375) ~[spring-batch-infrastructure-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.repeat.support.RepeatTemplate.executeInternal(RepeatTemplate.java:215) ~[spring-batch-infrastructure-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.repeat.support.RepeatTemplate.iterate(RepeatTemplate.java:145) ~[spring-batch-infrastructure-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.step.tasklet.TaskletStep.doExecute(TaskletStep.java:258) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.step.AbstractStep.execute(AbstractStep.java:203) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.job.SimpleStepHandler.handleStep(SimpleStepHandler.java:148) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.job.AbstractJob.handleStep(AbstractJob.java:399) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.job.SimpleJob.doExecute(SimpleJob.java:135) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.job.AbstractJob.execute(AbstractJob.java:313) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.launch.support.SimpleJobLauncher$1.run(SimpleJobLauncher.java:144) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.core.task.SyncTaskExecutor.execute(SyncTaskExecutor.java:50) ~[spring-core-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.launch.support.SimpleJobLauncher.run(SimpleJobLauncher.java:137) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:343) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$PassthruAdvice.invoke(SimpleBatchConfiguration.java:127) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at com.sun.proxy.$Proxy41.run(Unknown Source) ~[na:na]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.execute(JobLauncherCommandLineRunner.java:214) ~[spring-boot-autoconfigure-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.executeLocalJobs(JobLauncherCommandLineRunner.java:186) ~[spring-boot-autoconfigure-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.launchJobFromProperties(JobLauncherCommandLineRunner.java:172) ~[spring-boot-autoconfigure-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.run(JobLauncherCommandLineRunner.java:166) ~[spring-boot-autoconfigure-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:813) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:797) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:324) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) ~[spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
	at com.example.demo.DemoApplication.main(DemoApplication.java:12) ~[classes/:na]
Caused by: org.springframework.transaction.TransactionTimedOutException: Transaction timed out: deadline was Thu Jul 25 11:25:40 CEST 2019
	at org.springframework.transaction.support.ResourceHolderSupport.checkTransactionTimeout(ResourceHolderSupport.java:155) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.transaction.support.ResourceHolderSupport.getTimeToLiveInMillis(ResourceHolderSupport.java:144) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.transaction.support.ResourceHolderSupport.getTimeToLiveInSeconds(ResourceHolderSupport.java:128) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.datasource.DataSourceUtils.applyTimeout(DataSourceUtils.java:288) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.core.JdbcTemplate.applyStatementSettings(JdbcTemplate.java:1343) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:616) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.core.JdbcTemplate.update(JdbcTemplate.java:862) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.jdbc.core.JdbcTemplate.update(JdbcTemplate.java:917) ~[spring-jdbc-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.repository.dao.JdbcExecutionContextDao.persistSerializedContext(JdbcExecutionContextDao.java:233) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.repository.dao.JdbcExecutionContextDao.updateExecutionContext(JdbcExecutionContextDao.java:161) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext(SimpleJobRepository.java:211) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:343) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:294) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:98) ~[spring-tx-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at com.sun.proxy.$Proxy38.updateExecutionContext(Unknown Source) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:343) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$PassthruAdvice.invoke(SimpleBatchConfiguration.java:127) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212) ~[spring-aop-5.1.2.RELEASE.jar:5.1.2.RELEASE]
	at com.sun.proxy.$Proxy38.updateExecutionContext(Unknown Source) ~[na:na]
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:452) ~[spring-batch-core-4.1.0.RELEASE.jar:4.1.0.RELEASE]
	... 37 common frames omitted

2019-07-25 11:25:50.553  INFO 63306 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [FAILED]
2019-07-25 11:25:50.557  INFO 63306 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-07-25 11:25:50.560  INFO 63306 --- [       Thread-1] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

Process finished with exit code 0
```
