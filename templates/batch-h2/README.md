## 1. Start H2 database in server mode

1.1 Run H2 in server mode:

```
$> java -cp lib/h2-2.2.224.jar org.h2.tools.Server -tcp -web -ifNotExists
TCP server running at tcp://192.168.1.15:9092 (only local connections)
Web Console server running at http://192.168.1.15:8082 (only local connections)
```

1.2 Go to the H2 console at `http://localhost:8082`, connect to `jdbc:h2:tcp://localhost/~/test` (user:'sa' , pwd:'')

1.3 Run the script in `src/main/sql/schema-h2.sql`

The database `test` (file `test.mv.db`) wil be automatically created in `~`.

## 2. Stop H2 database

In the same terminal, hit `ctrl+c` to stop the server.