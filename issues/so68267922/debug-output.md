```
[main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@1376c05c
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'stepScope'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobScope'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'SO68267922'
[main] DEBUG org.springframework.core.LocalVariableTableParameterNameDiscoverer - Cannot find '.class' file for class [class com.example.demo.SO68267922$$EnhancerBySpringCGLIB$$b36b3e30] - unable to determine constructor/method parameter names
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobBuilders'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'stepBuilders'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Autowiring by type from bean name 'SO68267922' via constructor to bean named 'jobBuilders'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Autowiring by type from bean name 'SO68267922' via constructor to bean named 'stepBuilders'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.batch.core.configuration.annotation.ScopeConfiguration'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobRepository'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobLauncher'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobRegistry'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'jobExplorer'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'transactionManager'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'job'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'masterStep'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'slaveStep'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'partitioner'
[main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'taskExecutor'
[main] DEBUG org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$ReferenceTargetSource - Initializing lazy target object
[main] WARN org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer - No datasource was provided...using a Map based JobRepository
[main] WARN org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer - No transaction manager was provided, using a ResourcelessTransactionManager
[main] DEBUG org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource - Adding transactional method [*] with attribute [PROPAGATION_REQUIRED,ISOLATION_DEFAULT]
[main] DEBUG org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource - Adding transactional method [create*] with attribute [PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE]
[main] DEBUG org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource - Adding transactional method [getLastJobExecution*] with attribute [PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE]
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - No TaskExecutor has been set, defaulting to synchronous executor.
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastJobExecution]: PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@70cf32e3]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.createJobExecution]: PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@50f6ac94]
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
[main] DEBUG org.springframework.batch.core.job.AbstractJob - Job execution starting: JobExecution: id=0, version=0, startTime=null, endTime=null, lastUpdated=Tue Jul 06 17:28:16 CEST 2021, status=STARTING, exitStatus=exitCode=UNKNOWN;exitDescription=, job=[JobInstance: id=0, version=0, Job=[job]], jobParameters=[{}]
[main] DEBUG org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$ReferenceTargetSource - Initializing lazy target object
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@f14a7d4]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@52e7a6b2]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getStepExecutionCount]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@29a5f4e7]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.add]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2931522b]
[main] INFO org.springframework.batch.core.job.SimpleStepHandler - Executing step: [masterStep]
[main] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=1
[main] DEBUG org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$ReferenceTargetSource - Initializing lazy target object
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6057aebb]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3081f72c]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6e005dc9]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@436c81a3]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@59e32960]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5b67bb7e]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@20f5281c]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@301eda63]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@59cba5a]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6f19ac19]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@71329995]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5454d35e]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@455b6df1]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3f67593e]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@41ab013]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1115ec15]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@59e505b2]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@43b9fd5]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@8e50104]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6f7923a5]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@54eb2b70]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@63611043]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2d778add]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1838ccb8]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7d9e8ef7]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@51133c06]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4241e0f4]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@60410cd]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@95e33cc]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1e44b638]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@babafc2]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@ae3540e]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3688eb5b]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7922d892]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@345f69f3]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3f57bcad]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.getLastStepExecution]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@51549490]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.addAll]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@e5a654f]
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 0
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 1
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=25
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 2
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=6
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 3
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=34
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 4
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=35
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 5
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=4
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 6
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=13
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 7
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=31
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 8
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=33
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 9
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=8
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 10
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=16
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@17101eb2]
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 11
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@64ba4271]
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@11cda28e]
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=19
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=3
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 12
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 13
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@17cd211e]
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3e7c0a98]
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@420ba0c3]
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=2
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 14
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=22
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@602fe36a]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3d3d6680]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=5
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@52269adb]
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@58606ef4]
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@40c4833f]
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7a16edb]
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1b9986e]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@669b6f54]
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5e2be8e4]
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Concurrency count 15 has reached limit 15 - blocking
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@32ee82b7]
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@176f99d]
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@615f25c3]
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@79c9c608]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@29a93e74]
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7f9ca05c]
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6c4cb7bb]
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6fee2f68]
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5520c668]
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7655a50c]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@55ffbef8]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@3735010b
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@77025a50
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@2baf32c
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@70bcf73c]
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@4cc7cdf3
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@3725e26c
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@57da9207
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@15567a6d
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@690cd83a]
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@1b52df4c
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@4cd29a46
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5ae40648]
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@140740c9
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@3812d50d
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$ReferenceTargetSource - Initializing lazy target object
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4718332f]
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@4d6d6589
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@4d08506e
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@1741492
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@79897f13
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
SimpleAsyncTaskExecutor-4 starting step: slaveStep:partition4
SimpleAsyncTaskExecutor-6 starting step: slaveStep:partition12
SimpleAsyncTaskExecutor-7 starting step: slaveStep:partition16
SimpleAsyncTaskExecutor-3 starting step: slaveStep:partition20
SimpleAsyncTaskExecutor-1 starting step: slaveStep:partition31
SimpleAsyncTaskExecutor-2 starting step: slaveStep:partition28
SimpleAsyncTaskExecutor-5 starting step: slaveStep:partition21
SimpleAsyncTaskExecutor-14 starting step: slaveStep:partition0
SimpleAsyncTaskExecutor-9 starting step: slaveStep:partition27
SimpleAsyncTaskExecutor-8 starting step: slaveStep:partition19
SimpleAsyncTaskExecutor-12 starting step: slaveStep:partition11
SimpleAsyncTaskExecutor-11 starting step: slaveStep:partition34
SimpleAsyncTaskExecutor-10 starting step: slaveStep:partition30
SimpleAsyncTaskExecutor-13 starting step: slaveStep:partition9
SimpleAsyncTaskExecutor-15 starting step: slaveStep:partition22
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=5, version=1, name=slaveStep:partition22, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=13, version=1, name=slaveStep:partition12, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=2, version=1, name=slaveStep:partition0, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=33, version=1, name=slaveStep:partition19, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=35, version=1, name=slaveStep:partition4, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=31, version=1, name=slaveStep:partition16, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=4, version=1, name=slaveStep:partition21, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=6, version=1, name=slaveStep:partition28, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=3, version=1, name=slaveStep:partition11, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=8, version=1, name=slaveStep:partition27, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=19, version=1, name=slaveStep:partition34, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=22, version=1, name=slaveStep:partition9, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=16, version=1, name=slaveStep:partition30, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=34, version=1, name=slaveStep:partition20, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=25, version=1, name=slaveStep:partition31, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1fc539fc]
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@699fe5f]
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7d13511e]
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6d52ea73]
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@65b10b95]
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@52d89f9e]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=8
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2b880eca]
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2fed894c]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=19
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@51a00b3c]
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4cb89b91]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=13
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=16
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=5
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=4
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5c6b7eef]
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=34
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@368147e]
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=22
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4c1b4479]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7eaed]
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@ee82f49]
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=31
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4f4f1cab]
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@536a50ad]
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=2
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@16c60c0f]
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@374e88e0]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=33
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@78e3f2bb]
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=35
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=6
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@33cc4e64]
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=3
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@50e7d544]
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=25
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@da7e0e1]
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1e2f8043]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2df0cc4e]
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3e9c6c64]
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2677b2eb]
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@f69aa71]
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6dcd9d55]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@42cd9daf]
[SimpleAsyncTaskExecutor-13] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition9] executed in 10s21ms
[SimpleAsyncTaskExecutor-7] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition16] executed in 10s22ms
[SimpleAsyncTaskExecutor-8] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition19] executed in 10s23ms
[SimpleAsyncTaskExecutor-6] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition12] executed in 10s22ms
[SimpleAsyncTaskExecutor-10] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition30] executed in 10s22ms
[SimpleAsyncTaskExecutor-11] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition34] executed in 10s21ms
[SimpleAsyncTaskExecutor-14] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition0] executed in 10s21ms
[SimpleAsyncTaskExecutor-12] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition11] executed in 10s22ms
[SimpleAsyncTaskExecutor-15] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition22] executed in 10s20ms
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-4] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition4] executed in 10s24ms
[SimpleAsyncTaskExecutor-1] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition31] executed in 10s23ms
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-3] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition20] executed in 10s24ms
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition21] executed in 10s23ms
[SimpleAsyncTaskExecutor-2] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition28] executed in 10s23ms
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-9] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition27] executed in 10s22ms
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@53db46b2]
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@12cc4d1d]
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@57c69653]
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@595a4f04]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@a4ac150]
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@17c60384]
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1d071c6d]
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@64e6356]
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5801205f]
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2334d918]
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2a737ce6]
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@26f16900]
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@179e56d0]
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@196ad7ea]
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6a1ff95d]
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=22, version=3, name=slaveStep:partition9, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-13] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 14
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 14
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=8, version=3, name=slaveStep:partition27, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=19, version=3, name=slaveStep:partition34, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-11] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 14
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 14
[SimpleAsyncTaskExecutor-9] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 14
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=25, version=3, name=slaveStep:partition31, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-1] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 13
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=21
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=35, version=3, name=slaveStep:partition4, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 13
[SimpleAsyncTaskExecutor-4] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 13
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=9
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=2, version=3, name=slaveStep:partition0, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=3, version=3, name=slaveStep:partition11, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-14] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 12
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-12] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 11
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=24
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=16, version=3, name=slaveStep:partition30, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=4, version=3, name=slaveStep:partition21, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=6, version=3, name=slaveStep:partition28, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 11
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=13, version=3, name=slaveStep:partition12, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=5, version=3, name=slaveStep:partition22, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-2] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 11
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=34, version=3, name=slaveStep:partition20, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=33, version=3, name=slaveStep:partition19, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-5] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 10
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=31, version=3, name=slaveStep:partition16, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-10] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 9
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-6] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 8
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@48c25be3]
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=7
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 8
[SimpleAsyncTaskExecutor-8] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 8
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-3] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 7
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1da20923]
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-15] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 6
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 6
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1fb69086]
[SimpleAsyncTaskExecutor-7] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 6
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=10
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 6
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@15900663]
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2f28902e]
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 7
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=17
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 8
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=23
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4a08e582]
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@f31ae09]
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=18
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@ecac774
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@13063268
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=15
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@133421ea]
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 9
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@97b9245
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 10
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@341b6905]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=28
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 11
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@564f3811
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@286bd092]
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=29
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=32
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@389fff3d]
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7fc4bd92]
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@372b313]
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 12
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 13
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@572dc979]
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@17e973d2]
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@773f9041
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7d88a325]
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=27
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@666b2469]
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=11
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@10f539c4]
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 14
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@257618e2]
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@4f9ae830
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@187e9bb4
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=36
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@46e4eaea]
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@3666a6ba
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3fff2d92]
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Concurrency count 15 has reached limit 15 - blocking
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5262ef18]
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5b70de38]
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1466047d]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7f62ded3]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@1c42e986
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@4cc24401
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@321f8231
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2bdc6516]
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@97326b7]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4da26e7a]
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@457181cf
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@79d310ea
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4c29b4ae]
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6ebc998d]
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@51a22b3
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@3783a5bf
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
SimpleAsyncTaskExecutor-17 starting step: slaveStep:partition18
SimpleAsyncTaskExecutor-16 starting step: slaveStep:partition33
SimpleAsyncTaskExecutor-18 starting step: slaveStep:partition15
SimpleAsyncTaskExecutor-19 starting step: slaveStep:partition7
SimpleAsyncTaskExecutor-20 starting step: slaveStep:partition29
SimpleAsyncTaskExecutor-24 starting step: slaveStep:partition26
SimpleAsyncTaskExecutor-23 starting step: slaveStep:partition10
SimpleAsyncTaskExecutor-22 starting step: slaveStep:partition2
SimpleAsyncTaskExecutor-25 starting step: slaveStep:partition3
SimpleAsyncTaskExecutor-27 starting step: slaveStep:partition24
SimpleAsyncTaskExecutor-29 starting step: slaveStep:partition8
SimpleAsyncTaskExecutor-21 starting step: slaveStep:partition23
SimpleAsyncTaskExecutor-26 starting step: slaveStep:partition32
SimpleAsyncTaskExecutor-28 starting step: slaveStep:partition25
SimpleAsyncTaskExecutor-30 starting step: slaveStep:partition6
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=21, version=1, name=slaveStep:partition33, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=27, version=1, name=slaveStep:partition25, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=18, version=1, name=slaveStep:partition10, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=29, version=1, name=slaveStep:partition32, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=23, version=1, name=slaveStep:partition2, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=15, version=1, name=slaveStep:partition26, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=28, version=1, name=slaveStep:partition3, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=10, version=1, name=slaveStep:partition29, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=24, version=1, name=slaveStep:partition15, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=36, version=1, name=slaveStep:partition6, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=32, version=1, name=slaveStep:partition24, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=9, version=1, name=slaveStep:partition18, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=7, version=1, name=slaveStep:partition7, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=17, version=1, name=slaveStep:partition23, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=11, version=1, name=slaveStep:partition8, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@51881f36]
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1178fabd]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@70942eb4]
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=21
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@24a01c55]
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@65e71443]
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@49e4994]
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=10
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=27
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=28
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2e6b39dd]
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=23
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@11e8f39c]
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=18
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6be790aa]
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=15
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6bcfab4b]
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7b39fec5]
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@17b3252c]
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@75d4fe38]
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3a0a3af7]
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=36
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@73ae940]
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-23] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition10] executed in 10s9ms
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5a7ce81]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3133a2a2]
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=29
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-16] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition33] executed in 10s10ms
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@539ffd7d]
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-25] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition3] executed in 10s8ms
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6e60c2dc]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=11
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=32
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=24
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@173c0ab8]
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=17
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7d75ff18]
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3d8da2bd]
[SimpleAsyncTaskExecutor-20] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition29] executed in 10s9ms
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=7
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@163dac95]
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-30] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition6] executed in 10s8ms
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@62a88d71]
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=9
[SimpleAsyncTaskExecutor-28] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition25] executed in 10s8ms
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@29f72d41]
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-24] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition26] executed in 10s10ms
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@22269c90]
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@10f34f78]
[SimpleAsyncTaskExecutor-27] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition24] executed in 10s9ms
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1d36ddae]
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=18, version=3, name=slaveStep:partition10, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@11355d02]
[SimpleAsyncTaskExecutor-18] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition15] executed in 10s11ms
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2255d0f5]
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3049bbb2]
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2118dd68]
[SimpleAsyncTaskExecutor-19] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition7] executed in 10s11ms
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@dc1af50]
[SimpleAsyncTaskExecutor-23] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 14
[SimpleAsyncTaskExecutor-26] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition32] executed in 10s10ms
[SimpleAsyncTaskExecutor-22] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition2] executed in 10s10ms
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-17] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition18] executed in 10s12ms
[SimpleAsyncTaskExecutor-29] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition8] executed in 10s8ms
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 14
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Concurrency count 15 has reached limit 15 - blocking
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5e462cf4]
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=28, version=3, name=slaveStep:partition3, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=14
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@661a563]
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@32b6c2b6]
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3144506f]
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6059fb45]
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=21, version=3, name=slaveStep:partition33, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@674b58f1]
[SimpleAsyncTaskExecutor-21] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition23] executed in 10s12ms
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@25291e3a]
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@325eb8e3]
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@43624952]
[SimpleAsyncTaskExecutor-16] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 14
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-25] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 13
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=36, version=3, name=slaveStep:partition6, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 13
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@1bb41e7d]
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@39543751]
[SimpleAsyncTaskExecutor-30] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 13
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 13
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5ff51967]
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@49096400]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=20
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@5033097e]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=30
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 14
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@70fcb8f3
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Concurrency count 15 has reached limit 15 - blocking
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=11, version=3, name=slaveStep:partition8, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-29] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 14
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=12
[main] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Entering throttle at concurrency count 14
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=15, version=3, name=slaveStep:partition26, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-24] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 14
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.core.step.AbstractStep - Executing: id=26
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=24, version=3, name=slaveStep:partition15, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@71203610]
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=29, version=3, name=slaveStep:partition32, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-18] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 13
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=27, version=3, name=slaveStep:partition25, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=23, version=3, name=slaveStep:partition2, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=7, version=3, name=slaveStep:partition7, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@62d46cda]
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=17, version=3, name=slaveStep:partition23, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=32, version=3, name=slaveStep:partition24, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-21] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 12
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@656fcaf5]
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=9, version=3, name=slaveStep:partition18, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=10, version=3, name=slaveStep:partition29, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@4bdb9ca2]
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-19] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 11
[SimpleAsyncTaskExecutor-22] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 10
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@2507e78]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-27] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 9
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@208ca105
[SimpleAsyncTaskExecutor-28] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 8
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-26] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 7
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-17] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 6
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@9305f69]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@63636128]
[SimpleAsyncTaskExecutor-20] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 5
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@26b5a84c
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@51a73f6f]
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@412d9f20
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Starting repeat context.
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat operation about to start at count=1
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Preparing chunk execution for StepContext: org.springframework.batch.core.scope.context.StepContext@43be1e8d
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.core.scope.context.StepContextRepeatCallback - Chunk execution starting: queue size=0
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [null]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
SimpleAsyncTaskExecutor-31 starting step: slaveStep:partition14
SimpleAsyncTaskExecutor-32 starting step: slaveStep:partition5
SimpleAsyncTaskExecutor-34 starting step: slaveStep:partition1
SimpleAsyncTaskExecutor-33 starting step: slaveStep:partition13
SimpleAsyncTaskExecutor-35 starting step: slaveStep:partition17
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Applying contribution: [StepContribution: read=0, written=0, filtered=0, readSkips=0, writeSkips=0, processSkips=0, exitStatus=COMPLETED]
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=26, version=1, name=slaveStep:partition17, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=20, version=1, name=slaveStep:partition5, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=30, version=1, name=slaveStep:partition13, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=12, version=1, name=slaveStep:partition1, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.core.step.tasklet.TaskletStep - Saving step execution before commit: StepExecution: id=14, version=1, name=slaveStep:partition14, status=STARTED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0, exitDescription=
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Participating in existing transaction
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@3d0cf45a]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@20c4c437]
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@31e656fc]
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@fa8d125]
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=30
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@499e520b]
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=26
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=20
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=14
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.repeat.support.RepeatTemplate - Repeat is complete according to policy and result value.
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=12
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7bb2c870]
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@371ab3fb]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@655de647]
[SimpleAsyncTaskExecutor-35] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition17] executed in 10s6ms
[SimpleAsyncTaskExecutor-33] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition13] executed in 10s7ms
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-32] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition5] executed in 10s8ms
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@20441f4f]
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@7ffbfdf9]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-31] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition14] executed in 10s11ms
[SimpleAsyncTaskExecutor-34] INFO org.springframework.batch.core.step.AbstractStep - Step: [slaveStep:partition1] executed in 10s8ms
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@6cea9034]
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@29bb09fa]
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@53f77d23]
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@65995fdc]
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@12a967eb]
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=26, version=3, name=slaveStep:partition17, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-35] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 4
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=30, version=3, name=slaveStep:partition13, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-33] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 3
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=20, version=3, name=slaveStep:partition5, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-32] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 2
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=12, version=3, name=slaveStep:partition1, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-34] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 1
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=14, version=3, name=slaveStep:partition14, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=1, rollbackCount=0
[SimpleAsyncTaskExecutor-31] DEBUG org.springframework.core.task.SimpleAsyncTaskExecutor$ConcurrencyThrottleAdapter - Returning from throttle at concurrency count 0
[main] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution success: id=1
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@326acc7c]
[main] INFO org.springframework.batch.core.step.AbstractStep - Step: [masterStep] executed in 30s204ms
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@68d4ed14]
[main] DEBUG org.springframework.batch.core.step.AbstractStep - Step execution complete: StepExecution: id=1, version=2, name=masterStep, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=35, rollbackCount=0
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.updateExecutionContext]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@d6db63e]
[main] DEBUG org.springframework.batch.core.job.AbstractJob - Upgrading JobExecution status: StepExecution: id=1, version=2, name=masterStep, status=COMPLETED, exitStatus=COMPLETED, readCount=0, filterCount=0, writeCount=0 readSkipCount=0, writeSkipCount=0, processSkipCount=0, commitCount=35, rollbackCount=0, exitDescription=
[main] DEBUG org.springframework.batch.core.job.AbstractJob - Job execution complete: JobExecution: id=0, version=1, startTime=Tue Jul 06 17:28:16 CEST 2021, endTime=null, lastUpdated=Tue Jul 06 17:28:16 CEST 2021, status=COMPLETED, exitStatus=exitCode=COMPLETED;exitDescription=, job=[JobInstance: id=0, version=0, Job=[job]], jobParameters=[{}]
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Creating new transaction with name [org.springframework.batch.core.repository.support.SimpleJobRepository.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Initiating transaction commit
[main] DEBUG org.springframework.batch.support.transaction.ResourcelessTransactionManager - Committing resourceless transaction on [org.springframework.batch.support.transaction.ResourcelessTransactionManager$ResourcelessTransaction@414c63f1]
[main] INFO org.springframework.batch.core.launch.support.SimpleJobLauncher - Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 30s217ms
```