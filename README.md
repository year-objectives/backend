# Yearly Objectives backend

This project provides a REST Api to manage yearly objectives persistence backend

## Running the application in dev mode

You can run your application locally in dev mode byt first starting the local containers

```sh
docker compose up -d
./gradlew bootRun --args='--spring.profiles.active=dev'
```

## Running with debug

```sh
./gradlew bootRun --args='--spring.profiles.active=dev --debug'
```

## Accessing through swagger

To access the api there is a [swagger page](http://localhost:8080/api/v1/swagger-ui/index.html) to try the API and check its documentation.

Furthermore, there is a [hoppscotsch collection](./yearly.json) file that you can load and run the requests.
This file will be maintained in the future as development and testing tool.