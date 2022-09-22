```
[main] INFO org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory - Starting embedded database: url='jdbc:h2:mem:9d7d90b3-5f0f-43e4-b131-14f6e61413d5;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false', username='sa'
[main] INFO org.springframework.batch.core.repository.support.JobRepositoryFactoryBean - No database type set, using meta data indicating: H2
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - No TaskExecutor has been set, defaulting to synchronous executor.
[main] WARN org.springframework.batch.core.listener.AbstractListenerFactoryBean - org.springframework.batch.item.ItemWriter is an interface. The implementing class will not be queried for annotation based listener configurations. If using @StepScope on a @Bean method, be sure to return the implementing class so listener annotations can be used.
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
[main] INFO org.springframework.batch.core.job.SimpleStepHandler - Executing step: [step]
[main] ERROR org.springframework.batch.core.step.AbstractStep - Encountered an error executing step step in job job
java.lang.IllegalStateException: No Scope registered for scope name 'step'
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:368)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
	at org.springframework.aop.target.SimpleBeanTargetSource.getTarget(SimpleBeanTargetSource.java:35)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:692)
	at org.springframework.batch.item.support.ListItemReader$$EnhancerBySpringCGLIB$$4a48c2e3.read(<generated>)
	at org.springframework.batch.core.step.item.SimpleChunkProvider.doRead(SimpleChunkProvider.java:99)
	at org.springframework.batch.core.step.item.SimpleChunkProvider.read(SimpleChunkProvider.java:180)
	at org.springframework.batch.core.step.item.SimpleChunkProvider$1.doInIteration(SimpleChunkProvider.java:126)
	at org.springframework.batch.repeat.support.RepeatTemplate.getNextResult(RepeatTemplate.java:375)
	at org.springframework.batch.repeat.support.RepeatTemplate.executeInternal(RepeatTemplate.java:215)
	at org.springframework.batch.repeat.support.RepeatTemplate.iterate(RepeatTemplate.java:145)
	at org.springframework.batch.core.step.item.SimpleChunkProvider.provide(SimpleChunkProvider.java:118)
	at org.springframework.batch.core.step.item.ChunkOrientedTasklet.execute(ChunkOrientedTasklet.java:71)
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
	at com.example.demo.GH3936.main(GH3936.java:55)
[main] INFO org.springframework.batch.core.step.AbstractStep - Step: [step] executed in 14ms
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [FAILED] in 44ms

```