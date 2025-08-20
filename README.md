# spring-cloud-function
A generic function to run in various environments such as AWS Lambda, Azure Functions, and Google Cloud Functions.

## Example
- [spring-cloud-function-samples](https://github.com/spring-cloud/spring-cloud-function/tree/main/spring-cloud-function-samples).
- [Vanilla](https://github.com/spring-cloud/spring-cloud-function/blob/master/spring-cloud-function-samples/function-sample).
- [Plain Old Function](https://github.com/spring-cloud/spring-cloud-function/blob/master/spring-cloud-function-samples/function-sample-pof).
- [AWS Lambda](https://github.com/spring-cloud/spring-cloud-function/tree/master/spring-cloud-function-samples/function-sample-aws).
- [Microsoft Azure](https://github.com/spring-cloud/spring-cloud-function/tree/master/spring-cloud-function-samples/function-sample-azure).
- [Google Cloud Functions](https://github.com/spring-cloud/spring-cloud-function/tree/master/spring-cloud-function-samples/function-sample-gcp-http).


## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image -Pnative
$ docker run --rm spring-cloud-function:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./mvnw native:compile -Pnative

# Then, you can run the app as follows:
$ target/spring-cloud-function

# To run your existing tests in a native image, run the following goal:
$ ./mvnw test -PnativeTest
```


