### About this repository

This repository shows an example of a chunk-oriented step that writes data to two distributed databases.
There are 4 items in total and the chunk size is set to 2. This results in 2 chunks of 2 items each.
In the example, the second chunk contains an item with a value higher than the column size in the database,
which should generate an exception and fail the entire chunk. The expected result is the following:
- the first chunk should be written correctly in both databases
- the second chunk should fail and no data is written in any of the databases

### Run two mysql servers:

```
$ docker-compose -f src/docker/docker-compose.yml up
```

### Build and run the sample:

##### From an IDE

Import the Maven project and run the `com.example.demo.DistributedBatchJobApplication` class without any argument.

##### From the CLI

```
$ mvn package
$ mvn exec:java -Dexec.mainClass=com.example.demo.DistributedBatchJobApplication
```

##### Sample output

```
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - Loaded jar:file:~/.m2/repository/com/atomikos/transactions/5.0.9/transactions-5.0.9.jar!/transactions-defaults.properties
[main] WARN com.atomikos.icatch.provider.imp.AssemblerImp - Thanks for using Atomikos! This installation is not registered yet. 
REGISTER FOR FREE at http://www.atomikos.com/Main/RegisterYourDownload and receive:
- tips & advice 
- working demos 
- access to the full documentation 
- special exclusive bonus offers not available to others 
- everything you need to get the most out of using Atomikos!
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING core version: 5.0.9
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.oltp_max_retries = 5
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.log_base_dir = ./
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.tm_unique_name = 192.168.1.95.tm
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.default_jta_timeout = 10000
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.serial_jta_transactions = true
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.allow_subtransactions = true
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.log_base_name = tmlog
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.oltp_retry_interval = 10000
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.checkpoint_interval = 500
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.default_max_wait_time_on_shutdown = 9223372036854775807
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.forget_orphaned_log_entries_delay = 86400000
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.throw_on_heuristic = false
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.force_shutdown_on_vm_exit = false
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.enable_logging = true
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.max_timeout = 300000
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.recovery_delay = 10000
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.logcloud_datasource_name = logCloudDS
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - USING: com.atomikos.icatch.max_actives = 50
[main] INFO com.atomikos.icatch.provider.imp.AssemblerImp - Using default (local) logging and recovery...
Thanks for using Atomikos! This installation is not registered yet. 
REGISTER FOR FREE at http://www.atomikos.com/Main/RegisterYourDownload and receive:
- tips & advice 
- working demos 
- access to the full documentation 
- special exclusive bonus offers not available to others 
- everything you need to get the most out of using Atomikos!
[main] INFO org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory - Starting embedded database: url='jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false', username='sa'
[main] INFO org.springframework.batch.core.repository.support.JobRepositoryFactoryBean - No database type set, using meta data indicating: H2
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - No TaskExecutor has been set, defaulting to synchronous executor.
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
[main] INFO org.springframework.batch.core.job.SimpleStepHandler - Executing step: [step]
[main] WARN com.atomikos.jdbc.internal.AbstractDataSourceBean - ds1: poolSize equals default - this may cause performance problems!
[main] WARN com.atomikos.jdbc.internal.AbstractDataSourceBean - ds2: poolSize equals default - this may cause performance problems!
[main] ERROR org.springframework.batch.core.step.AbstractStep - Encountered an error executing step step in job job
org.springframework.dao.DataIntegrityViolationException: PreparedStatementCallback; SQL [INSERT INTO PEOPLE (id, name) VALUES (?, ?)]; Data truncation: Data too long for column 'name' at row 1; nested exception is java.sql.BatchUpdateException: Data truncation: Data too long for column 'name' at row 1
	at org.springframework.jdbc.support.SQLStateSQLExceptionTranslator.doTranslate(SQLStateSQLExceptionTranslator.java:104)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:70)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:79)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:79)
	at org.springframework.jdbc.core.JdbcTemplate.translateException(JdbcTemplate.java:1541)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:667)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:691)
	at org.springframework.jdbc.core.JdbcTemplate.batchUpdate(JdbcTemplate.java:1034)
	at org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate.batchUpdate(NamedParameterJdbcTemplate.java:373)
	at org.springframework.batch.item.database.JdbcBatchItemWriter.write(JdbcBatchItemWriter.java:182)
	at com.example.demo.DistributedBatchJobConfiguration.lambda$itemWriter$0(DistributedBatchJobConfiguration.java:60)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.writeItems(SimpleChunkProcessor.java:193)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.doWrite(SimpleChunkProcessor.java:159)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.write(SimpleChunkProcessor.java:294)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.process(SimpleChunkProcessor.java:217)
	at org.springframework.batch.core.step.item.ChunkOrientedTasklet.execute(ChunkOrientedTasklet.java:77)
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:407)
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:331)
	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140)
	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:273)
	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIteration(StepContextRepeatCallback.java:82)
	at org.springframework.batch.repeat.support.RepeatTemplate.getNextResult(RepeatTemplate.java:375)
	at org.springframework.batch.repeat.support.RepeatTemplate.executeInternal(RepeatTemplate.java:215)
	at org.springframework.batch.repeat.support.RepeatTemplate.iterate(RepeatTemplate.java:145)
	at org.springframework.batch.core.step.tasklet.TaskletStep.doExecute(TaskletStep.java:258)
	at org.springframework.batch.core.step.AbstractStep.execute(AbstractStep.java:208)
	at org.springframework.batch.core.job.SimpleStepHandler.handleStep(SimpleStepHandler.java:152)
	at org.springframework.batch.core.job.AbstractJob.handleStep(AbstractJob.java:413)
	at org.springframework.batch.core.job.SimpleJob.doExecute(SimpleJob.java:136)
	at org.springframework.batch.core.job.AbstractJob.execute(AbstractJob.java:320)
	at org.springframework.batch.core.launch.support.SimpleJobLauncher$1.run(SimpleJobLauncher.java:149)
	at org.springframework.core.task.SyncTaskExecutor.execute(SyncTaskExecutor.java:50)
	at org.springframework.batch.core.launch.support.SimpleJobLauncher.run(SimpleJobLauncher.java:140)
	at com.example.demo.DistributedBatchJobApplication.main(DistributedBatchJobApplication.java:18)
Caused by: java.sql.BatchUpdateException: Data truncation: Data too long for column 'name' at row 1
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
	at com.mysql.cj.util.Util.handleNewInstance(Util.java:192)
	at com.mysql.cj.util.Util.getInstance(Util.java:167)
	at com.mysql.cj.util.Util.getInstance(Util.java:174)
	at com.mysql.cj.jdbc.exceptions.SQLError.createBatchUpdateException(SQLError.java:224)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeBatchSerially(ClientPreparedStatement.java:816)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeBatchInternal(ClientPreparedStatement.java:418)
	at com.mysql.cj.jdbc.StatementImpl.executeBatch(StatementImpl.java:795)
	at com.mysql.cj.jdbc.StatementWrapper.executeBatch(StatementWrapper.java:545)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at com.atomikos.util.DynamicProxySupport.callNativeMethod(DynamicProxySupport.java:175)
	at com.atomikos.util.DynamicProxySupport.invoke(DynamicProxySupport.java:118)
	at jdk.proxy2/jdk.proxy2.$Proxy16.executeBatch(Unknown Source)
	at org.springframework.jdbc.core.JdbcTemplate.lambda$batchUpdate$4(JdbcTemplate.java:1048)
	at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:651)
	... 28 more
Caused by: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column 'name' at row 1
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:104)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:916)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeUpdateInternal(ClientPreparedStatement.java:1061)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeBatchSerially(ClientPreparedStatement.java:795)
	... 40 more
[main] INFO org.springframework.batch.core.step.AbstractStep - Step: [step] executed in 622ms
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [FAILED] in 652ms
Total persons in dataSource1 = 2
Total persons in dataSource2 = 2
```

##### Check databases content

```
% docker exec -it mysql1 bash
root@4c29de0b0b0b:/# mysql -u root test -p # the root password is "root"
Enter password:
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 8.0.27 MySQL Community Server - GPL

Copyright (c) 2000, 2021, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> select * from PEOPLE;
+----+---------+
| id | name    |
+----+---------+
|  1 | foobar1 |
|  2 | foobar2 |
+----+---------+
2 rows in set (0.01 sec)

mysql> exit
Bye
root@4c29de0b0b0b:/# exit
exit


% docker exec -it mysql2 bash
root@67faa7c7772e:/# mysql -u root test -p # the root password is "root"
Enter password:
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 8.0.27 MySQL Community Server - GPL

Copyright (c) 2000, 2021, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> select * from PEOPLE;
+----+---------+
| id | name    |
+----+---------+
|  1 | foobar1 |
|  2 | foobar2 |
+----+---------+
2 rows in set (0.00 sec)

mysql>
```

As expected, the first chunk has been written to both databases, whereas the second chunk has not
since the distributed transaction was rolled back.
