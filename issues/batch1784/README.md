### 1. Setup H2 database in server mode

1.1 Download h2 database and run it in server mode:

```
$> curl https://search.maven.org/remotecontent\?filepath\=com/h2database/h2/1.4.199/h2-1.4.199.jar -o h2-1.4.199.jar
$> java -cp h2-1.4.199.jar org.h2.tools.Server -tcp -web -ifNotExists
TCP server running at tcp://localhost:9092 (only local connections)
Web Console server running at http://localhost:8082 (only local connections)
```

1.2 Go to the h2 console at `http://localhost:8082`, connect to `jdbc:h2:tcp://localhost/~/test` (user:'sa' , pwd:'')

1.3 Run the following script: `https://github.com/spring-projects/spring-batch/blob/master/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-h2.sql`

The database `test` (file `test.mv.db`) wil be automatically created in `~`.

### 2. Generate 100_000 job instances/executions

Run the `com.example.demo.DemoApplication` app which will generate 100_000 instances of the same job.

### 3. Test the performance of starting the next instance

Run the `com.example.demo.PerformanceTestApplication` which will time the operation of starting
the next job instance using both `jobOperator.startNextInstance` and `CommandLineJobRunner` with `-next` option.
