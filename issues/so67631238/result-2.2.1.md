```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.1.RELEASE)

2021-05-25 11:15:17.150  INFO 44270 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on mbenhassine-a02.vmware.com with PID 44270 (/Users/mbenhassine/Downloads/spring-batch-data-jpa-persistence-issue-mvp-master/target/classes started by mbenhassine in /Users/mbenhassine/Downloads/spring-batch-data-jpa-persistence-issue-mvp-master)
2021-05-25 11:15:17.152  INFO 44270 --- [           main] com.example.demo.DemoApplication         : The following profiles are active: h2
2021-05-25 11:15:17.417  INFO 44270 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
2021-05-25 11:15:17.449  INFO 44270 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 28ms. Found 1 repository interfaces.
2021-05-25 11:15:17.643  INFO 44270 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2021-05-25 11:15:17.678  INFO 44270 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.4.8.Final}
2021-05-25 11:15:17.735  INFO 44270 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2021-05-25 11:15:17.777  INFO 44270 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-05-25 11:15:17.851  INFO 44270 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-05-25 11:15:17.860  INFO 44270 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
Hibernate: drop table person if exists
Hibernate: create table person (id binary not null, first_name varchar(255), last_name varchar(255), primary key (id))
2021-05-25 11:15:18.132  INFO 44270 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-05-25 11:15:18.136  INFO 44270 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2021-05-25 11:15:18.321  WARN 44270 --- [           main] o.s.b.c.s.b.FaultTolerantStepBuilder     : Asynchronous TaskExecutor detected with ItemStream reader.  This is probably an error, and may lead to incorrect restart data being stored.
2021-05-25 11:15:18.362  WARN 44270 --- [           main] o.s.b.a.batch.JpaBatchConfigurer         : JPA does not support custom isolation levels, so locks may not be taken when launching Jobs
2021-05-25 11:15:18.364  INFO 44270 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2021-05-25 11:15:18.374  INFO 44270 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2021-05-25 11:15:18.470  INFO 44270 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.56 seconds (JVM running for 1.966)
2021-05-25 11:15:18.470  INFO 44270 --- [           main] o.s.b.a.b.JobLauncherCommandLineRunner   : Running default command line with: []
2021-05-25 11:15:18.507  INFO 44270 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=jobToLoadDataFromCsv]] launched with the following parameters: [{}]
2021-05-25 11:15:18.529  INFO 44270 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [stepToLoadDataFromCsv]
2021-05-25 11:15:18.540  WARN 44270 --- [           main] o.s.batch.core.step.item.ChunkMonitor    : No ItemReader set (must be concurrent step), so ignoring offset data.
2021-05-25 11:15:18.557  INFO 44270 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'scopedTarget.taskExecutor'
2021-05-25 11:15:18.571  WARN 44270 --- [.taskExecutor-1] o.s.batch.core.step.item.ChunkMonitor    : ItemStream was opened in a different thread.  Restart data could be compromised.
2021-05-25 11:15:18.571  INFO 44270 --- [.taskExecutor-1] c.example.demo.writer.PersonItemWriter   : About to write Person entities to [h2] database...
2021-05-25 11:15:18.589  INFO 44270 --- [.taskExecutor-1] c.example.demo.writer.PersonItemWriter   : Finished writing Person entities to [[h2]] database in 18 milliseconds...
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
Hibernate: insert into person (first_name, last_name, id) values (?, ?, ?)
2021-05-25 11:15:18.601  INFO 44270 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [stepToLoadDataFromCsv] executed in 72ms
2021-05-25 11:15:18.602  INFO 44270 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'scopedTarget.taskExecutor'
2021-05-25 11:15:18.604  INFO 44270 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=jobToLoadDataFromCsv]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 86ms
Hibernate: select person0_.id as id1_0_, person0_.first_name as first_na2_0_, person0_.last_name as last_nam3_0_ from person person0_
person = Person{id=6ab572c7-559d-4695-886e-eeb36688b685, firstName='Jill', lastName='Doe'}
person = Person{id=5d19c1fd-c041-4049-b726-ccb697c06de5, firstName='Joe', lastName='Doe'}
person = Person{id=7cf030e4-943a-4702-932b-3a20e08a6ecf, firstName='Justin', lastName='Doe'}
person = Person{id=3b1e40fe-140d-4332-a515-863c56a2daa0, firstName='Jane', lastName='Doe'}
person = Person{id=68855afc-7acd-4155-a16e-42799f261256, firstName='John', lastName='Doe'}
2021-05-25 11:15:18.656  INFO 44270 --- [extShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2021-05-25 11:15:18.656  INFO 44270 --- [extShutdownHook] .SchemaDropperImpl$DelayedDropActionImpl : HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
Hibernate: drop table person if exists
2021-05-25 11:15:18.659  INFO 44270 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2021-05-25 11:15:18.661  INFO 44270 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```