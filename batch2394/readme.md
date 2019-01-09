Run DB2 in a docker container (from [https://hub.docker.com/r/ibmcom/db2express-c/](https://hub.docker.com/r/ibmcom/db2express-c/)):

```
$ docker run -v /Users/mbenhassine/data/db2:/share -d -p 50000:50000 -e DB2INST1_PASSWORD=springbatchdb2 -e LICENSE=accept ibmcom/db2express-c:latest db2start
```

Then create a test db (surprisingly, `springbatch` and `SPRINGBATCH` are not valid names..):

```
$ docker exec -it 35dad591fd47 bash
[root@35dad591fd47 /]# su - db2inst1
Last login: Mon Jan  7 13:36:25 UTC 2019
[db2inst1@35dad591fd47 ~]$ db2 create db springbatch
SQL1001N  "springbatch" is not a valid database name.  SQLSTATE=2E000
[db2inst1@35dad591fd47 ~]$ db2 create db SPRINGBATCH
SQL1001N  "SPRINGBATCH" is not a valid database name.  SQLSTATE=2E000
[db2inst1@35dad591fd47 ~]$ db2 create db EXAMPLE
DB20000I  The CREATE DATABASE command completed successfully.
```

Finally, run `org/springframework/batch/core/schema-db2.sql` and `src/main/resources/schema-and-data.sql` against the db2 server.

---

For MySQL, see revision 410390c36d67c91f0fef4cb3a736257f4c55f768.
