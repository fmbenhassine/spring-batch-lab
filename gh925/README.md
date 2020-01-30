#### Run from the IDE

In IntelliJ, run `MyJobTest` with code coverage and choose "JaCoCo" as coverage runner.

#### Run from the CLI

```shell script
$>mvn clean jacoco:prepare-agent compile jacoco:instrument test jacoco:report
```

#### Result

Using both ways, the `Person` class is instrumented by JaCoCo and still no exception
is thrown when running the test or generating the coverage report:

```shell script
...
Checking fields in the Person class
id
name
$jacocoData
...
```
