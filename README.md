# AWS Spring Boot Native DSQL

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