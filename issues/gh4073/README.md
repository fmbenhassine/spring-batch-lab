#### 1. Download h2 jar and run it in server mode:

```
$> java -cp h2-2.1.214.jar org.h2.tools.Server -tcp -web -ifNotExists
TCP server running at tcp://localhost:9092 (only local connections)
Web Console server running at http://localhost:8082 (only local connections)
```

The database `test` (file `test.mv.db`) wil be automatically created in `~` when requested the first time.

Go to h2 web console at `http://localhost:8082`, connect to the db with the following parameters:

* Driver class: `org.h2.Driver`
* JDBC url: `jdbc:h2:tcp://localhost/~/test`
* User name: `sa`
* Password: (empty)

Then execute the script [schema-h2.sql](https://github.com/spring-projects/spring-batch/blob/master/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-h2.sql).

#### 2. Run the app

Execute `DemoApplication`.  It should print something like this:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.6)

2023-04-27T10:13:52.199+02:00  INFO 40042 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 17 with PID 40042 (/tmp/gh4073/target/classes started by mbenhassine in /tmp/gh4073)
2023-04-27T10:13:52.201+02:00  INFO 40042 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"
2023-04-27T10:13:52.653+02:00  INFO 40042 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-04-27T10:13:52.716+02:00  INFO 40042 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:tcp://localhost/~/test user=SA
2023-04-27T10:13:52.717+02:00  INFO 40042 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-04-27T10:13:52.876+02:00  INFO 40042 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.96 seconds (process running for 1.371)
2023-04-27T10:13:52.878+02:00  INFO 40042 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-04-27T10:13:52.936+02:00  INFO 40042 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{'run.id':'{value=1, type=class java.lang.Long, identifying=true}'}]
2023-04-27T10:13:52.957+02:00  INFO 40042 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
Hello world!
2023-04-27T10:13:52.968+02:00  INFO 40042 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step] executed in 10ms
2023-04-27T10:13:52.976+02:00  INFO 40042 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{'run.id':'{value=1, type=class java.lang.Long, identifying=true}'}] and the following status: [COMPLETED] in 28ms
2023-04-27T10:13:52.979+02:00  INFO 40042 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-04-27T10:13:52.986+02:00  INFO 40042 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

#### 3. Switch the incrementer and validator

Change the code in `MyJobConfiguration` as follows:

```diff
@Bean
public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
--    RunIdIncrementer jobParametersIncrementer = new RunIdIncrementer();
++    // RunIdIncrementer jobParametersIncrementer = new RunIdIncrementer();
    DefaultJobParametersValidator jobParametersValidator = new DefaultJobParametersValidator();
--    jobParametersValidator.setRequiredKeys(new String[]{"run.id"});
++    jobParametersValidator.setRequiredKeys(new String[]{"name"});

    return new JobBuilder("job", jobRepository)
            .start(new StepBuilder("step", jobRepository)
                    .tasklet((contribution, chunkContext) -> {
                        System.out.println("Hello world!");
                        return RepeatStatus.FINISHED;
                    }, transactionManager).build())
--            .incrementer(jobParametersIncrementer)
++            .incrementer(new MyIncrementer())
            .validator(jobParametersValidator)
            .build();
}
```

#### 4. ReRun the app

Execute `DemoApplication` again. It should print something like this:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.6)

2023-04-27T10:15:01.436+02:00  INFO 40065 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 17 with PID 40065 (/tmp/gh4073/target/classes started by mbenhassine in /tmp/gh4073)
2023-04-27T10:15:01.440+02:00  INFO 40065 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"
2023-04-27T10:15:01.838+02:00  INFO 40065 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-04-27T10:15:01.884+02:00  INFO 40065 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:tcp://localhost/~/test user=SA
2023-04-27T10:15:01.886+02:00  INFO 40065 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-04-27T10:15:02.021+02:00  INFO 40065 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.821 seconds (process running for 1.192)
2023-04-27T10:15:02.022+02:00  INFO 40065 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-04-27T10:15:02.077+02:00  INFO 40065 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{'name':'{value=foo, type=class java.lang.String, identifying=true}','run.id':'{value=1, type=class java.lang.Long, identifying=true}'}]
2023-04-27T10:15:02.097+02:00  INFO 40065 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
Hello world!
2023-04-27T10:15:02.109+02:00  INFO 40065 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step] executed in 11ms
2023-04-27T10:15:02.117+02:00  INFO 40065 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{'name':'{value=foo, type=class java.lang.String, identifying=true}','run.id':'{value=1, type=class java.lang.Long, identifying=true}'}] and the following status: [COMPLETED] in 28ms
2023-04-27T10:15:02.121+02:00  INFO 40065 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-04-27T10:15:02.128+02:00  INFO 40065 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

Note how the `run.id` parameter is still passed to the second instance (coming from the previous execution), but it should not cause any issue as the validator was updated accordingly to ignore it.