```
[main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@2957fcb0
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'stepScope'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobScope'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'myJobConfiguration'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.batch.core.configuration.annotation.ScopeConfiguration'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobRepository'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobLauncher'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobRegistry'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobExplorer'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'transactionManager'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobBuilders'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'stepBuilders'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'itemReader'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'itemWriter'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'taskExecutor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'job'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Autowiring by type from bean name 'job' via factory method to bean named 'jobBuilders'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Autowiring by type from bean name 'job' via factory method to bean named 'stepBuilders'
[main] DEBUG org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$ReferenceTargetSource - Initializing lazy target object
[main] WARN org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer - No datasource was provided...using a Map based JobRepository
[main] WARN org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer - No transaction manager was provided, using a ResourcelessTransactionManager
[main] DEBUG org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource - Adding transactional method [*] with attribute [PROPAGATION_REQUIRED,ISOLATION_DEFAULT]
[main] DEBUG org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource - Adding transactional method [create*] with attribute [PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE]
[main] DEBUG org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource - Adding transactional method [getLastJobExecution*] with attribute [PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE]
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - No TaskExecutor has been set, defaulting to synchronous executor.
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastJobExecution]: PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4bff7da0]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.createJobExecution]: PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@14008db3]
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] launched with the following parameters: [{poolSize=null}]
[main] DEBUG org.springframework.batch.core.job.AbstractJob - Job execution starting: JobExecution: id=0, version=0, startTime=null, endTime=null, lastUpdated=Fri Jun 25 16:45:44 CEST 2021, status=STARTING, exitStatus=exitCode=UNKNOWN;exitDescription=, job=[JobInstance: id=0, version=0, Job=[job]], jobParameters=[{poolSize=null}]
[main] DEBUG org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$ReferenceTargetSource - Initializing lazy target object
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@36b4091c]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4671115f]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getStepExecutionCount]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@36cda2c2]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.add]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1800a575]
[main] INFO org.springframework.batch.core.job.SimpleStepHandler - Executing step: [step]
[main] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=1
[main] DEBUG org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$ReferenceTargetSource - Initializing lazy target object
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@38234a38]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6bffbc6d]
[main] DEBUG org.springframework.batch.repeat.support.TaskExecutorRepeatTemplate - Starting repeat context.
[main] DEBUG org.springframework.batch.core.scope.StepScope - Creating object in scope=step, name=scopedTarget.taskExecutor
[main] DEBUG org.springframework.batch.repeat.support.TaskExecutorRepeatTemplate - Handling exception: org.springframework.beans.factory.UnsatisfiedDependencyException, caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'scopedTarget.taskExecutor' defined in com.example.demo.MyJobConfiguration: Unsatisfied dependency expressed through method 'taskExecutor' parameter 0; nested exception is org.springframework.beans.TypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: "null"
```