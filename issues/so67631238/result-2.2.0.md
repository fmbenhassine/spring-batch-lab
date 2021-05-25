```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.0.RELEASE)

2021-05-25 11:14:27.803  INFO 44251 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on mbenhassine-a02.vmware.com with PID 44251 (/Users/mbenhassine/Downloads/spring-batch-data-jpa-persistence-issue-mvp-master/target/classes started by mbenhassine in /Users/mbenhassine/Downloads/spring-batch-data-jpa-persistence-issue-mvp-master)
2021-05-25 11:14:27.804  INFO 44251 --- [           main] com.example.demo.DemoApplication         : The following profiles are active: h2
2021-05-25 11:14:28.130  INFO 44251 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
2021-05-25 11:14:28.167  INFO 44251 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 31ms. Found 1 repository interfaces.
2021-05-25 11:14:28.402  INFO 44251 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2021-05-25 11:14:28.447  INFO 44251 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.4.6.Final}
2021-05-25 11:14:28.530  INFO 44251 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2021-05-25 11:14:28.580  INFO 44251 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-05-25 11:14:28.646  INFO 44251 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-05-25 11:14:28.660  INFO 44251 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
Hibernate: drop table person if exists
Hibernate: create table person (id binary not null, first_name varchar(255), last_name varchar(255), primary key (id))
2021-05-25 11:14:28.987  INFO 44251 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-05-25 11:14:28.993  INFO 44251 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2021-05-25 11:14:29.208  WARN 44251 --- [           main] o.s.b.c.s.b.FaultTolerantStepBuilder     : Asynchronous TaskExecutor detected with ItemStream reader.  This is probably an error, and may lead to incorrect restart data being stored.
2021-05-25 11:14:29.251  WARN 44251 --- [           main] o.s.b.a.batch.JpaBatchConfigurer         : JPA does not support custom isolation levels, so locks may not be taken when launching Jobs
2021-05-25 11:14:29.252  INFO 44251 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2021-05-25 11:14:29.261  INFO 44251 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2021-05-25 11:14:29.369  INFO 44251 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.79 seconds (JVM running for 2.169)
2021-05-25 11:14:29.370  INFO 44251 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: []
2021-05-25 11:14:29.402  INFO 44251 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=jobToLoadDataFromCsv]] launched with the following parameters: [{}]
2021-05-25 11:14:29.434  INFO 44251 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [stepToLoadDataFromCsv]
2021-05-25 11:14:29.445  WARN 44251 --- [           main] o.s.batch.core.step.item.ChunkMonitor    : No ItemReader set (must be concurrent step), so ignoring offset data.
2021-05-25 11:14:29.460  INFO 44251 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'scopedTarget.taskExecutor'
2021-05-25 11:14:29.476  WARN 44251 --- [.taskExecutor-1] o.s.batch.core.step.item.ChunkMonitor    : ItemStream was opened in a different thread.  Restart data could be compromised.
2021-05-25 11:14:29.476  INFO 44251 --- [.taskExecutor-1] c.example.demo.writer.PersonItemWriter   : About to write Person entities to [h2] database...
2021-05-25 11:14:29.492  INFO 44251 --- [.taskExecutor-1] c.example.demo.writer.PersonItemWriter   : Finished writing Person entities to [[h2]] database in 16 milliseconds...
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
2021-05-25 11:14:29.505  INFO 44251 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [stepToLoadDataFromCsv] executed in 71ms
2021-05-25 11:14:29.506  INFO 44251 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'scopedTarget.taskExecutor'
2021-05-25 11:14:29.507  INFO 44251 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=jobToLoadDataFromCsv]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 84ms
Hibernate: select person0_.id as id1_0_, person0_.first_name as first_na2_0_, person0_.last_name as last_nam3_0_ from person person0_
person = Person{id=c1c570d8-b7a4-41b2-9265-60b3f46c85bf, firstName='Jill', lastName='Doe'}
person = Person{id=8c666fbf-7392-4016-bab3-e942f7f488df, firstName='Joe', lastName='Doe'}
person = Person{id=fe186c03-648e-47e0-92f2-b0db9d821861, firstName='Justin', lastName='Doe'}
person = Person{id=602e10be-5004-4b38-9045-7de7e0ff73c6, firstName='Jane', lastName='Doe'}
person = Person{id=35a3e732-66e5-4101-87fa-85d4fc335aa6, firstName='John', lastName='Doe'}
2021-05-25 11:14:29.580  INFO 44251 --- [extShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2021-05-25 11:14:29.580  INFO 44251 --- [extShutdownHook] .SchemaDropperImpl$DelayedDropActionImpl : HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
Hibernate: drop table person if exists
2021-05-25 11:14:29.583  INFO 44251 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2021-05-25 11:14:29.585  INFO 44251 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

```