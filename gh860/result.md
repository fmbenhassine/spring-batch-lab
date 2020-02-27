```
Feb 27, 2020 3:33:37 PM org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer initialize
WARNING: No datasource was provided...using a Map based JobRepository
Feb 27, 2020 3:33:37 PM org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer initialize
WARNING: No transaction manager was provided, using a ResourcelessTransactionManager
Feb 27, 2020 3:33:37 PM org.springframework.batch.core.launch.support.SimpleJobLauncher afterPropertiesSet
INFO: No TaskExecutor has been set, defaulting to synchronous executor.
Feb 27, 2020 3:33:37 PM org.springframework.batch.core.launch.support.SimpleJobLauncher$1 run
INFO: Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
Feb 27, 2020 3:33:37 PM org.springframework.batch.core.job.SimpleStepHandler handleStep
INFO: Executing step: [step]
item = foo9
item = foo7
item = foo5
item = foo6
item = foo20
Feb 27, 2020 3:33:37 PM org.springframework.batch.core.step.AbstractStep execute
SEVERE: Encountered an error executing step step in job job
org.springframework.batch.core.step.skip.SkipLimitExceededException: Skip limit of '5' exceeded
	at org.springframework.batch.core.step.skip.LimitCheckingItemSkipPolicy.shouldSkip(LimitCheckingItemSkipPolicy.java:133)
	at org.springframework.batch.core.step.skip.ExceptionClassifierSkipPolicy.shouldSkip(ExceptionClassifierSkipPolicy.java:70)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor.shouldSkip(FaultTolerantChunkProcessor.java:503)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor.access$500(FaultTolerantChunkProcessor.java:52)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor$2.recover(FaultTolerantChunkProcessor.java:279)
	at org.springframework.retry.support.RetryTemplate.handleRetryExhausted(RetryTemplate.java:512)
	at org.springframework.retry.support.RetryTemplate.doExecute(RetryTemplate.java:351)
	at org.springframework.retry.support.RetryTemplate.execute(RetryTemplate.java:211)
	at org.springframework.batch.core.step.item.BatchRetryTemplate.execute(BatchRetryTemplate.java:217)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor.transform(FaultTolerantChunkProcessor.java:298)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.process(SimpleChunkProcessor.java:210)
	at org.springframework.batch.core.step.item.ChunkOrientedTasklet.execute(ChunkOrientedTasklet.java:77)
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:407)
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:331)
	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140)
	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:273)
	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIteration(StepContextRepeatCallback.java:82)
	at org.springframework.batch.repeat.support.TaskExecutorRepeatTemplate$ExecutingRunnable.run(TaskExecutorRepeatTemplate.java:262)
	at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.IllegalArgumentException
	at com.example.demo.MyJob.lambda$itemProcessor$0(MyJob.java:39)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.doProcess(SimpleChunkProcessor.java:134)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor$1.doWithRetry(FaultTolerantChunkProcessor.java:233)
	at org.springframework.retry.support.RetryTemplate.doExecute(RetryTemplate.java:287)
	... 12 more

Feb 27, 2020 3:33:37 PM org.springframework.batch.core.step.AbstractStep execute
INFO: Step: [step] executed in 70ms
Feb 27, 2020 3:33:37 PM org.springframework.batch.core.launch.support.SimpleJobLauncher$1 run
INFO: Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [FAILED] in 96ms
```

```
Feb 27, 2020 3:34:33 PM org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer initialize
WARNING: No datasource was provided...using a Map based JobRepository
Feb 27, 2020 3:34:33 PM org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer initialize
WARNING: No transaction manager was provided, using a ResourcelessTransactionManager
Feb 27, 2020 3:34:33 PM org.springframework.batch.core.launch.support.SimpleJobLauncher afterPropertiesSet
INFO: No TaskExecutor has been set, defaulting to synchronous executor.
Feb 27, 2020 3:34:33 PM org.springframework.batch.core.launch.support.SimpleJobLauncher$1 run
INFO: Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
Feb 27, 2020 3:34:33 PM org.springframework.batch.core.job.SimpleStepHandler handleStep
INFO: Executing step: [step]
item = foo6
item = foo4
item = foo5
item = foo6
item = foo8
Feb 27, 2020 3:34:33 PM org.springframework.batch.core.step.AbstractStep execute
SEVERE: Encountered an error executing step step in job job
org.springframework.batch.core.step.skip.SkipLimitExceededException: Skip limit of '5' exceeded
	at org.springframework.batch.core.step.skip.LimitCheckingItemSkipPolicy.shouldSkip(LimitCheckingItemSkipPolicy.java:133)
	at org.springframework.batch.core.step.skip.ExceptionClassifierSkipPolicy.shouldSkip(ExceptionClassifierSkipPolicy.java:70)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor.shouldSkip(FaultTolerantChunkProcessor.java:503)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor.access$500(FaultTolerantChunkProcessor.java:52)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor$2.recover(FaultTolerantChunkProcessor.java:279)
	at org.springframework.retry.support.RetryTemplate.handleRetryExhausted(RetryTemplate.java:512)
	at org.springframework.retry.support.RetryTemplate.doExecute(RetryTemplate.java:351)
	at org.springframework.retry.support.RetryTemplate.execute(RetryTemplate.java:211)
	at org.springframework.batch.core.step.item.BatchRetryTemplate.execute(BatchRetryTemplate.java:217)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor.transform(FaultTolerantChunkProcessor.java:298)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.process(SimpleChunkProcessor.java:210)
	at org.springframework.batch.core.step.item.ChunkOrientedTasklet.execute(ChunkOrientedTasklet.java:77)
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:407)
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:331)
	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140)
	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:273)
	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIteration(StepContextRepeatCallback.java:82)
	at org.springframework.batch.repeat.support.TaskExecutorRepeatTemplate$ExecutingRunnable.run(TaskExecutorRepeatTemplate.java:262)
	at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.IllegalArgumentException
	at com.example.demo.MyJob.lambda$itemProcessor$0(MyJob.java:39)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.doProcess(SimpleChunkProcessor.java:134)
	at org.springframework.batch.core.step.item.FaultTolerantChunkProcessor$1.doWithRetry(FaultTolerantChunkProcessor.java:233)
	at org.springframework.retry.support.RetryTemplate.doExecute(RetryTemplate.java:287)
	... 12 more

Feb 27, 2020 3:34:33 PM org.springframework.batch.core.step.AbstractStep execute
INFO: Step: [step] executed in 87ms
Feb 27, 2020 3:34:33 PM org.springframework.batch.core.launch.support.SimpleJobLauncher$1 run
INFO: Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [FAILED] in 115ms
```
