#Java EE micro service starter kit with docker and payara micro
* In this example you can see how to setup build ready for micro service java ee environment.
* By default server will be running on port 8080

# Requirements:

1. [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. [Gradle 3.x](https://gradle.org/) 
3. [Docker](https://www.docker.com/products/overview)
4. [AWS Cli](http://docs.aws.amazon.com/cli/latest/userguide/installing.html)

###  Building project
```sh
gradle clean build -Penv=local
```

###  Starting embedded server
```sh
gradle startServer
```

### Starting tests:
```sh
gradle test -Penv=test
```

### Starting integration test:
All integration tests are running in docker.
```sh
gradle itest -Penv=test
```

###  Starting/stopping docker server
```sh
gradle startDocker
gradle stopDoker
```

### Example running apps manually:

You can simply run them as jar applications or 
you can configure your ide to run jar application so you can debug it.

```sh
gradle build -Penv=local
java -jar ./pajara-micro.jar --deploy ./build/libs/starter-1.0.0-local.war
```
note if you did not download payara micro run 
```sh
gradle downloadPayaraMicro
```


