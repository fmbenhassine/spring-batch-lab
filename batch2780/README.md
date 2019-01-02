# spring-batch-connection-issue

This sample project is my try to create a minimal, business-logic unrelated, test project to reproduce the issue described in https://jira.spring.io/browse/BATCH-2780.
To mitigate the issue, the connection pool size in the `application.yml` (property `spring.datasource.hikari.maximum-pool-size`) should be increased to at least 7.
