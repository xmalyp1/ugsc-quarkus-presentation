# ugsc-quarkus Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .
## Useful commands
### Create project
```shell script
mvn io.quarkus.platform:quarkus-maven-plugin:2.8.2.Final:create -DprojectGroupId=ugsc.presentations -DprojectArtifactId=ugsc-quarkus-tes1 -Dextensions="resteasy-reactive","jdbc-h2","jdbc-mysql","hibernate-orm-panache","smallrye-openapi","resteasy-reactive-jsonb"
```

### Start MySQL Database
```shell script
docker run -p 3306:3306 --name=mysqltest -e MYSQL_ROOT_PASSWORD=Password -e MYSQL_DATABASE=test -d mysql
```

### Start project in container
```shell script
./mvnw package
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/ugsc-quarkus-jvm .
docker run -i --rm -p 8080:8080 quarkus/ugsc-quarkus-jvm
```

### Start project in Native mode (OS Windows)
```shell script
native_executable.bat
docker build -f src/main/docker/Dockerfile.native -t quarkus/ugsc-quarkus:native .
docker run -i --rm -p 8080:8080 quarkus/ugsc-quarkus:native
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/ugsc-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A JAX-RS implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
