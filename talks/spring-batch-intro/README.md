# spring-batch-intro

This is a hands-on introduction lab to Spring Batch. You will learn how to develop, test, package, deploy and run batch
jobs using Spring Batch, Spring Boot, Spring Cloud Task and Spring Cloud Data Flow.

## Database setup

Spring Batch uses a relational database to store job execution meta-data. In this lab, we will use MySQL.

First, ensure a MySQL server is running on `localhost:3306`. If you use docker, you can run this command:

```
$>docker run -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql
```

Then create a schema for the lab:

```
mysql>create schema sbi;
mysql>use sbi;
```

And finally run the meta-data schema creation script for MySQL (that you can get [here](https://github.com/spring-projects/spring-batch/blob/master/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-mysql.sql)):

```
mysql>source schema-mysql.sql
```

## Job development

See `patches` directory and apply changes in order. The most important one is "Turn the app into a Spring Boot app":

* No need to configure the data source anymore, just declare its properties
* No need to manually create an uber jar with maven shade plugin
* No need to write a main method to load the context, get the Job and JobLauncher beans then create parameters and run the job
* No need to remember how to run the job from the command line (fully qualified class name of CommandLineJobRunner + parameters and their order), just run "java -jar myjob.jar param1=value1 param2=value2"

## Job Administration

First [download](https://cloud.spring.io/spring-cloud-dataflow/) and run Spring Cloud Data Flow server:

```
java -jar spring-cloud-dataflow-server-local-1.4.0.RELEASE.jar \
    --spring.datasource.url=jdbc:mysql://localhost:3306/sbi \
    --spring.datasource.username=root \
    --spring.datasource.password=root \
    --spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
```

This command starts the server and points it to the same database server used by Spring Batch jobs. Once the server is started, you can browse `localhost:9393/dashboard`.

Then, you can follow the step by step guide of how to deploy jobs in the [Task Developer Guide](http://docs.spring.io/spring-cloud-dataflow/docs/1.4.0.RELEASE/reference/htmlsingle/#task-dev-guide).

You can also [download](https://cloud.spring.io/spring-cloud-dataflow) and run the Spring Cloud Data Flow shell:

```
java -jar spring-cloud-dataflow-shell-1.4.0.RELEASE.jar \
    --spring.datasource.url=jdbc:mysql://localhost:3306/sbi \
    --spring.datasource.username=root \
    --spring.datasource.password=root \
    --spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
```

As for the server, the shell should point to the same database server to be able to show job instances and execution details.
