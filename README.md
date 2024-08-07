# atipera_quarkus_task

This project uses Quarkus, the Supersonic Subatomic Java Framework.
This API work with gitHub and return all repositories with branches and last sha commit

# example
GET /api/v1/github/repositories/{username}
    Headers: Accept: application/json
<img width="1301" alt="Screenshot 2024-08-07 at 19 05 28" src="https://github.com/user-attachments/assets/51cb6b22-7f05-4856-a193-ec464c91572a">
<img width="1301" alt="Screenshot 2024-08-07 at 19 05 54" src="https://github.com/user-attachments/assets/4ce3222a-70b1-495e-8762-41fe73685a8f">

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

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
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/atipera_quarkus_task-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST JSON-B ([guide](https://quarkus.io/guides/rest#json-serialisation)): JSON-B serialization support for Quarkus
  REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on
  it.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
