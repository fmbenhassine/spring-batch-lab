#### 1. Download h2 distribution and run it in server mode:

```
# mbenhassine @ localhost in ~/tools/h2/bin [13:50:21] C:130
$> java -cp h2-1.4.199.jar org.h2.tools.Server -tcp -web -ifNotExists
TCP server running at tcp://localhost:9092 (only local connections)
Web Console server running at http://localhost:8082 (only local connections)
```

The database `test` (file `test.mv.db`) wil be automatically created in `~` when requested the first time.

Go to h2 web console at `http://localhost:8082`, connect to the db execute the script [schema-h2.sql](https://github.com/spring-projects/spring-batch/blob/master/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-h2.sql).

#### 2. Generate 10_000 job instances / executions

Run the `DemoApplication` app. When finished, go to h2 web console at `http://localhost:8082`:

```
$> SELECT count(*) FROM BATCH_JOB_INSTANCE;

COUNT(*)
100000

$>SELECT count(*) FROM BATCH_JOB_EXECUTION

COUNT(*)
100000
```

#### 3. Measure the time to stop a job execution

Run the `DemoStopBatchJobWithCommandLineJobLauncher` app

#### 4. Results

##### v4.1.2 (11:28:56 -11:27:01 = 1min55s)

See `log-4.1.2.txt`

##### v4.2.0.RC1 (11:24:04 - 11:24:01 = 3s)

See `log-4.2.0.RC1.txt`
