This is a sample map/reduce word count application using Spring Batch.

The job is divided in two steps:

* Step 1 (tasklet): splits the input file into partitions
* Step 2 (partitioned): counts the number of words in each partition and aggregates
the results using a `StepExecutionAggregator` 

![Word count job](word-count-job.png)
