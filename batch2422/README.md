#### 1. Download h2 distribution and run it in server mode:

```
# mbenhassine @ localhost in ~/tools/h2/bin [13:50:21] C:130
$> java -cp h2-1.4.199.jar org.h2.tools.Server -tcp -web -ifNotExists
TCP server running at tcp://localhost:9092 (only local connections)
Web Console server running at http://localhost:8082 (only local connections)
```

The database `test` (file `test.mv.db`) wil be automatically created in `~` when requested the first time.

Go to h2 web console at `http://localhost:8082`, connect to the db execute the script in `spring-batch-core-4.1.2.RELEASE.jar!/org/springframework/batch/core/schema-h2.sql`

#### 2. Generate 10_000 job instances / executions

Run the `DemoApplication` app. When finished, go to h2 web console at `http://localhost:8082`:

```
$> SELECT count(*) FROM BATCH_JOB_INSTANCE;

COUNT(*)
10000

$>SELECT count(*) FROM BATCH_JOB_EXECUTION

COUNT(*)
10000
```

#### 3. Measure the time to stop a job execution

Run the `DemoStopBatchJob` app

#### 4. Results

##### 4.1 Stopping job execution

```
StopWatch '': running time (millis) = 67
-----------------------------------------
ms     %     Task name
-----------------------------------------
00067  100%  stopping job execution
```

##### 4.2 Direct call to jdbcJobInstanceDao.getJobInstance(jobExecution)

```
StopWatch '': running time (millis) = 1
-----------------------------------------
ms     %     Task name
-----------------------------------------
00001  100%  get job instance
```
