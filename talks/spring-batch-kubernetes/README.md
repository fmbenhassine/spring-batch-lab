### 1. Start a local docker registry and H2 database

```shell script
$>docker run -d -p 5000:5000 --restart=always --name registry registry:2
```

```shell script
$>java -cp h2-1.4.200.jar org.h2.tools.Server -tcp -tcpAllowOthers -web -ifNotExists
TCP server running at tcp://localhost:9092 (others can connect)
Web Console server running at http://localhost:8082 (only local connections)
```

Go to h2 web console at `http://localhost:8082`, connect to the db `jdbc:h2:tcp://localhost/~/testdb` with "sa"/"sa" and execute the script
 [schema-h2.sql](https://github.com/spring-projects/spring-batch/blob/master/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-h2.sql).

Create DB secrets in Kubernetes:

```shell script
$>kubectl apply -f src/kubernetes/secrets.yaml
```

### 2. Build the job image and push it to the local registry

```shell script
$>docker build -f src/docker/Dockerfile -t localhost:5000/benas/sbk:v0.1 .
```

Give the job a try by running it first in a docker container:

```shell script
$>docker run -e DB_URL=jdbc:h2:tcp://192.168.1.53/~/testdb -e DB_USER=sa -e DB_PASSWORD=sa localhost:5000/benas/sbk:v0.1
```

Note how the IP address is used to point to the DB server instead of `localhost` or `127.0.0.1` since the job is running inside a container.

Push the image to the local registry:

```shell script
$>docker push localhost:5000/benas/sbk:v0.1
```

### 3. Create a kubernetes job

```shell script
$>kubectl apply -f src/kubernetes/job.yaml
```

Check pods:

```shell script
$>kubectl get pods
NAME           READY   STATUS      RESTARTS   AGE
my-job-6k4ng   0/1     Completed   0          57m
```

Check logs:

```shell script
$>kubectl logs my-job-6k4ng
WARNING: No datasource was provided...using a Map based JobRepository
WARNING: No transaction manager was provided, using a ResourcelessTransactionManager
INFO: No TaskExecutor has been set, defaulting to synchronous executor.
INFO: Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
INFO: Executing step: [step]
hello world
INFO: Step: [step] executed in 31ms
INFO: Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 59ms
```

Delete the job:

```shell script
$>kubectl delete job my-job
job.batch "my-job" deleted
```

### 4. Create a kubernetes CronJob

```shell script
$>kubectl apply -f src/kubernetes/cron-job.yaml
cronjob.batch/my-periodic-job created
```

Check pods:

```shell script
$>kubectl get pods
NAME                               READY   STATUS      RESTARTS   AGE
my-periodic-job-1580310900-vl6kd   0/1     Completed   0          61s
my-periodic-job-1580310960-2k7xq   1/1     Running     0          1s
```

Check logs:

```shell script
$>kubectl logs my-periodic-job-1580310960-2k7xq
WARNING: No datasource was provided...using a Map based JobRepository
WARNING: No transaction manager was provided, using a ResourcelessTransactionManager
INFO: No TaskExecutor has been set, defaulting to synchronous executor.
INFO: Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
INFO: Executing step: [step]
hello world
INFO: Step: [step] executed in 44ms
INFO: Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 74ms
```

### 5. Update the image of the CronJob "on the fly" (CI/CD)

First, change the message `hello world` to `hello world!`:

```shell script
$>vim src/main/java/io/github/benas/sbk/JobConfiguration.java
```

Then build v0.2 of the image and push it to the local registry:

```shell script
$>docker build -f src/docker/Dockerfile -t localhost:5000/benas/sbk:v0.2 .
$>docker push localhost:5000/benas/sbk:v0.2
```

Finally, set the new image in the CronJob resource definition:

```shell script
$>kubectl set image cronjob/my-periodic-job my-periodic-job=localhost:5000/benas/sbk:v0.2
cronjob.batch/my-periodic-job image updated
```

NB: In a real CI/CD environment, a patch command can be issued from the build script
to kubernetes through its REST API: https://kubernetes.io/docs/reference/generated/kubernetes-api/v1.17/#patch-cronjob-v1beta1-batch

The next run should take into account the new changes:

```shell script
$>kubectl get pods
NAME                               READY   STATUS      RESTARTS   AGE
my-periodic-job-1580312940-w8fgd   0/1     Completed   0          2m5s
my-periodic-job-1580313000-tlr8q   0/1     Completed   0          65s
my-periodic-job-1580313060-lqk4h   0/1     Completed   0          5s

$>kubectl logs my-periodic-job-1580313060-lqk4h
WARNING: No datasource was provided...using a Map based JobRepository
WARNING: No transaction manager was provided, using a ResourcelessTransactionManager
INFO: No TaskExecutor has been set, defaulting to synchronous executor.
INFO: Job: [SimpleJob: [name=job]] launched with the following parameters: [{}]
INFO: Executing step: [step]
hello world!
INFO: Step: [step] executed in 47ms
INFO: Job: [SimpleJob: [name=job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 80ms
```
