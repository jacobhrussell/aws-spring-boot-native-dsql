# AWS Spring Boot Native DSQL

## Running Locally

Start the local postgres container: `docker-compose up -d`.

Run/debug as normal with your IDE.

## Deploying

To run these steps in one command you can use the `deploy.sh` script:

```shell
# chmod +x deploy.sh
./deploy.sh
```

Create Docker image we will build the application in

```shell
docker build --platform linux/amd64 -t al2023-graalvm21:native-web . --no-cache
```

Build the application

```shell
docker run --platform linux/amd64 -it -v `pwd`:`pwd` -w `pwd` -v ~/.m2:/root/.m2 al2023-graalvm21:native-web ./mvnw clean -Pnative package -DskipTests
```

Deploy via AWS SAM

```shell
sam deploy --guided --profile your-profile
```

Delete infrastructure

```shell
sam delete
```

## Endpoints

If you are using IntelliJ you can use the `http` directory for initiating local requests.

Create:

```shell
curl -X POST http://localhost:8080/book \
     -H "Content-Type: application/json" \
     -d '{
           "title": "The Great Gatsby"
         }' | jq
```

List all:

```shell
curl http://localhost:8080/book | jq
```

Find by id:

```shell
curl http://localhost:8080/book/1 | jq
```

Update:

```shell
curl -X PUT http://localhost:8080/book/1 \
     -H "Content-Type: application/json" \
     -d '{
           "title": "The Great Gatsby - Updated"
         }' | jq

```

Delete:

```shell
curl -X DELETE http://localhost:8080/book/1 | jq
```

## Connecting to Aurora DSQL

User your preferred RDMBS tool to connect via the Aurora DSQL endpoint found in the AWS Console. You can use the AWS
Console to create a short-lived token to use as a password. You will need to change the password by generating another
token through the console when it expires.

Schema visualization does not work, so you will need to query the Postgres system tables in order to see database
information:
- see all schemas: `select * from pg_namespace;`
- see all tables: `select * from pg_tables where schemaname = 'public';`

