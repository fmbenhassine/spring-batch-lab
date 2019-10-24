#### 1. Download h2 distribution and run it in server mode:

```
# mbenhassine @ localhost in ~/tools/h2/bin [13:50:21] C:130
$> java -cp h2-1.4.199.jar org.h2.tools.Server -tcp -web -ifNotExists
TCP server running at tcp://localhost:9092 (only local connections)
Web Console server running at http://localhost:8082 (only local connections)
```

The database `test` (file `test.mv.db`) wil be automatically created in `~` when requested the first time.

Go to h2 web console at `http://localhost:8082`, connect to the db execute the script [schema-h2.sql](https://github.com/spring-projects/spring-batch/blob/master/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-h2.sql).

#### 2. Run the app

Run the `DemoApplication` app.
 
#### 3. Check the progress in step execution context

Execute `SELECT * FROM BATCH_STEP_EXECUTION_CONTEXT` in H2 web console:

![progress](progress.png)
