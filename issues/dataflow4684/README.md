### How to run the sample

```
$> docker-compose up -d
$> mvn package
$> bash run-jobs.sh
```

Inspect DB tables and see `log*.txt` files.

### Code path leading to the issue

Source: https://github.com/spring-projects/spring-boot/blob/main/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/batch/JobLauncherApplicationRunner.java

Pseudo code when an incrementer is used:

```
protected void execute(Job job, JobParameters jobParameters) {
   JobParameters nextParameters = new JobParametersBuilder(jobParameters, this.jobExplorer)
                                    .getNextJobParameters(job)
                                    .toJobParameters();
   JobExecution execution = this.jobLauncher.run(job, nextParameters);
}
```

Since these two methods are not executed in the same transaction, `nextParameters` could contain
the same `run.id` from the previous execution (`JobParametersBuilder#getNextJobParameters` executes
a DB query which could return the same result for two different processes).