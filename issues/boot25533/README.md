### Start a mysql server

```
$ docker-compose -f src/docker/docker-compose.yml up
```

This will initialize the server with Spring Batch metadata tables.

### Build the project

```
$> mvn package
```

### Run the job

```
$ java -cp target/demo-0.0.1-SNAPSHOT.jar org.springframework.batch.core.launch.support.CommandLineJobRunner -next com.example.demo.MyJobConfig job name=foo -yada=yada
[main] WARN org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer - No transaction manager was provided, using a DataSourceTransactionManager
[main] INFO org.springframework.batch.core.repository.support.JobRepositoryFactoryBean - No database type set, using meta data indicating: MYSQL
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - No TaskExecutor has been set, defaulting to synchronous executor.
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] launched with the following parameters: [{name=foo, run.id=1, yada=yada}]
[main] INFO org.springframework.batch.core.job.SimpleStepHandler - Executing step: [step]
hello world
[main] INFO org.springframework.batch.core.step.AbstractStep - Step: [step] executed in 193ms
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] completed with the following parameters: [{name=foo, run.id=1, yada=yada}] and the following status: [COMPLETED] in 509ms
```

```
$ java -cp target/demo-0.0.1-SNAPSHOT.jar org.springframework.batch.core.launch.support.CommandLineJobRunner -next com.example.demo.MyJobConfig job name=foo
[main] WARN org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer - No transaction manager was provided, using a DataSourceTransactionManager
[main] INFO org.springframework.batch.core.repository.support.JobRepositoryFactoryBean - No database type set, using meta data indicating: MYSQL
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - No TaskExecutor has been set, defaulting to synchronous executor.
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] launched with the following parameters: [{name=foo, run.id=2}]
[main] INFO org.springframework.batch.core.job.SimpleStepHandler - Executing step: [step]
hello world
[main] INFO org.springframework.batch.core.step.AbstractStep - Step: [step] executed in 182ms
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] completed with the following parameters: [{name=foo, run.id=2}] and the following status: [COMPLETED] in 451ms
```

### Check job parameters in db

```
$ docker exec -it mysql bash
root@31a82cfe702c:/# mysql -u root test -p # the root password is "root"
Enter password:
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 46
Server version: 8.0.21 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> select * from BATCH_JOB_EXECUTION_PARAMS;
+------------------+---------+----------+------------+----------------------------+----------+------------+-------------+
| JOB_EXECUTION_ID | TYPE_CD | KEY_NAME | STRING_VAL | DATE_VAL                   | LONG_VAL | DOUBLE_VAL | IDENTIFYING |
+------------------+---------+----------+------------+----------------------------+----------+------------+-------------+
|                1 | STRING  | name     | foo        | 1970-01-01 01:00:00.000000 |        0 |          0 | Y           |
|                1 | LONG    | run.id   |            | 1970-01-01 01:00:00.000000 |        1 |          0 | Y           |
|                1 | STRING  | yada     | yada       | 1970-01-01 01:00:00.000000 |        0 |          0 | N           |
|                2 | STRING  | name     | foo        | 1970-01-01 01:00:00.000000 |        0 |          0 | Y           |
|                2 | LONG    | run.id   |            | 1970-01-01 01:00:00.000000 |        2 |          0 | Y           |
+------------------+---------+----------+------------+----------------------------+----------+------------+-------------+
5 rows in set (0.00 sec)
```