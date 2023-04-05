# start MariaDB container

```shell
$>docker run  --env MARIADB_USER=admin --env MARIADB_PASSWORD=root --env MARIADB_ROOT_PASSWORD=root --env MARIADB_DATABASE=test -p3306:3306  mariadb:10.11.2
```

# Run the app

Run the spring boot app (CLI or IDE):

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.5)

2023-04-05T14:42:47.818+02:00  INFO 43131 --- [           main] com.example.demodb.DemoDbApplication     : Starting DemoDbApplication using Java 17 with PID 43131 (in /demo-db)
2023-04-05T14:42:47.821+02:00  INFO 43131 --- [           main] com.example.demodb.DemoDbApplication     : No active profile set, falling back to 1 default profile: "default"
2023-04-05T14:42:48.265+02:00  INFO 43131 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-04-05T14:42:48.314+02:00  INFO 43131 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.mariadb.jdbc.Connection@748fe51d
2023-04-05T14:42:48.316+02:00  INFO 43131 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-04-05T14:42:48.561+02:00  INFO 43131 --- [           main] com.example.demodb.DemoDbApplication     : Started DemoDbApplication in 1.011 seconds (process running for 1.396)
2023-04-05T14:42:48.563+02:00  INFO 43131 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-04-05T14:42:48.621+02:00  INFO 43131 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
2023-04-05T14:42:48.648+02:00  INFO 43131 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step]
hello world
2023-04-05T14:42:48.669+02:00  INFO 43131 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [step] executed in 20ms
2023-04-05T14:42:48.688+02:00  INFO 43131 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 51ms
2023-04-05T14:42:48.691+02:00  INFO 43131 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-04-05T14:42:48.702+02:00  INFO 43131 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```

# Check DB results

```shell
root@2ffa80962ab6:/# mariadb -u admin -p
Enter password:
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 13
Server version: 10.11.2-MariaDB-1:10.11.2+maria~ubu2204 mariadb.org binary distribution

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> use test;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
MariaDB [test]> show tables;
+------------------------------+
| Tables_in_test               |
+------------------------------+
| BATCH_JOB_EXECUTION          |
| BATCH_JOB_EXECUTION_CONTEXT  |
| BATCH_JOB_EXECUTION_PARAMS   |
| BATCH_JOB_EXECUTION_SEQ      |
| BATCH_JOB_INSTANCE           |
| BATCH_JOB_SEQ                |
| BATCH_STEP_EXECUTION         |
| BATCH_STEP_EXECUTION_CONTEXT |
| BATCH_STEP_EXECUTION_SEQ     |
+------------------------------+
9 rows in set (0.000 sec)

MariaDB [test]> select * from BATCH_JOB_INSTANCE;
+-----------------+---------+----------+----------------------------------+
| JOB_INSTANCE_ID | VERSION | JOB_NAME | JOB_KEY                          |
+-----------------+---------+----------+----------------------------------+
|               1 |       0 | job      | d41d8cd98f00b204e9800998ecf8427e |
+-----------------+---------+----------+----------------------------------+
1 row in set (0.000 sec)

MariaDB [test]> select * from BATCH_JOB_EXECUTION;
+------------------+---------+-----------------+----------------------------+----------------------------+----------------------------+-----------+-----------+--------------+----------------------------+
| JOB_EXECUTION_ID | VERSION | JOB_INSTANCE_ID | CREATE_TIME                | START_TIME                 | END_TIME                   | STATUS    | EXIT_CODE | EXIT_MESSAGE | LAST_UPDATED               |
+------------------+---------+-----------------+----------------------------+----------------------------+----------------------------+-----------+-----------+--------------+----------------------------+
|                1 |       2 |               1 | 2023-04-05 14:42:48.593947 | 2023-04-05 14:42:48.627505 | 2023-04-05 14:42:48.678680 | COMPLETED | COMPLETED |              | 2023-04-05 14:42:48.679723 |
+------------------+---------+-----------------+----------------------------+----------------------------+----------------------------+-----------+-----------+--------------+----------------------------+
1 row in set (0.000 sec)

MariaDB [test]>
```