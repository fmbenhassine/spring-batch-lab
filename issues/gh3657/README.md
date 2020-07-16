#### 1. Execute the app

Run the `com.example.demo.StepExecutionCountBenchmarkApp` class from the IDE or run:

```
$>mvn clean package
$>jar -jar target/demo-0.0.1-SNAPSHOT.jar
```

#### 2. Results: JobRepository.getStepExecutionCount execution time

#### 100.000 step executions

###### First run

* v4.2.4:    stepExecutionCount = 10000 in 0.739089535s
* v2.4.0-M1: stepExecutionCount = 10000 in 0.192064916s

###### Second run

* v4.2.4:    stepExecutionCount = 10000 in 0.802702499s
* v2.4.0-M1: stepExecutionCount = 10000 in 0.186782075s

#### 1.000.000 step executions

###### First run

* v4.2.4:    stepExecutionCount = 10000 in 6.02932536s
* v2.4.0-M1: stepExecutionCount = 10000 in 1.282847666s

###### Second run

* v4.2.4:    stepExecutionCount = 10000 in 5.220367525s
* v2.4.0-M1: stepExecutionCount = 10000 in 1.19726736s
