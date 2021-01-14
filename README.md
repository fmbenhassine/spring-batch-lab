# About this repository

This reposiotry contains all my work related to Spring Batch:

* `blog`: Source code of my blog posts about Spring Batch
* `issues`: [Minimal complete examples](https://stackoverflow.com/help/minimal-reproducible-example) to (try to) reproduce issues reported on Github and StackOverflow
* `diagrams`: UML diagrams generated from Spring Batch's code to help understanding class hierarchies
* `samples`: Additional samples to complement the [official ones](https://github.com/spring-projects/spring-batch/tree/master/spring-batch-samples)
* `talks`: Source code of my talks on Spring Batch
* `templates`: Template projects I use to quickly create and prototype new projects
* `sandbox`: Draft ideas related to Spring Batch that will probably be never finished or implemented

# How to checkout a single project folder?

This repository contains dozens of projects and you might want to checkout only a single folder instead of the entire repository. This can be done with the `git sparse-checkout` command. For example, if you want to only checkout the source code of my blog post about running Spring Batch jobs on Kubernetes [here](https://github.com/benas/spring-batch-lab/tree/master/blog/spring-batch-kubernetes), you can run the following commands:

```
$> git clone --sparse --depth 1 https://github.com/benas/spring-batch-lab
$> cd spring-batch-lab
$> git sparse-checkout add blog/spring-batch-kubernetes
```

At this point you, you should only have the source code of that blog post in your clone:

```
$ tree .
.
├── README.md
└── blog
    └── spring-batch-kubernetes
        ├── data
        │   ├── sample1.csv
        │   └── sample2.csv
        ├── pom.xml
        └── src
            ├── docker
            │   └── docker-compose.yml
            ├── kubernetes
            │   ├── database-service.yaml
            │   └── job.yaml
            ├── main
            │   └── java
            │       └── com
            │           └── example
            │               └── demo
            │                   ├── BootifulJobApplication.java
            │                   └── Person.java
            └── sql
                └── database.sql

12 directories, 10 files
```
