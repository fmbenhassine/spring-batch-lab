## 1. Start a PostgreSQL server

1.1 Run the following command:

```shell
$>docker-compose up -d
```

1.2 Open `http://localhost:5050/browser/` in a browser and login with `admin@admin.com`/`root`

1.3 Configure a new Server

Go to `Dashboard` then click `Add New Server` and set the following parameters:

* General -> Name: postgres
* Connection -> Hostname: postgres
* Connection -> Port: 5432
* Connection -> Maintenance database: postgres
* Connection -> Username: postgres
* Connection -> Password: postgres

## 2. Stop the PostgreSQL server

Once you finish the Lab, stop the server with the following command:

```shell
$>docker-compose stop
```