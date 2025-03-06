## Generate input file

```
$>for i in {1..100000}; do echo "foo${i},bar${i}" >> persons.csv; done
```

## Run benchmarks

From within the IDE, run `[XXX]JobRepositoryIntegrationTests`

## Results

Average value of 5 executions:

- PostgreSQL: 41s
- MongoDB: 19s
- Resourceless: 0.8s

Hardware: Apple Macbook Air with M2 CPU, 16 GB Mermory, MacOS Sequoia 15.3
Java version: Oracle JDK 17.0.12