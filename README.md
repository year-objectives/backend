# Yearly Objectives backend

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```sh
./mvnw quarkus:dev
```

## Running with debug

```sh
./mvnw quarkus:dev -Ddebug
```


> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```sh
./mvnw package
```
## Creating a native executable

```sh
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/objectives-backend-1.0.0-SNAPSHOT-runner`