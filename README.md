# Java EE micro service starter kit with docker, payara micro, arquillian on AWS Cloud 
* This is complete example how to setup java ee ready for micro service AWS Cloud deployment with AWS elastic beanstalk
and AWS Code pipeline via AWS Code Build


## Requirements:

1. [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. [Gradle 3.x](https://gradle.org/) 
3. [Docker](https://www.docker.com/products/overview)
4. [AWS Cli](http://docs.aws.amazon.com/cli/latest/userguide/installing.html)

##  Setting up properties 
Before changing properties you need to setup:
* AWS IAM user account with Elastic Beanstalk / EC2 Container read write permissions.
* EC2 Container Registry and Elastic Beanstalk Single environment application with docker engine

Change aws config in gradle.properties:
```properties
groupName=icoder
awsAccessKey=YOUR_ACCESS_KEY
awsSecretKey=YOUR_SECRET_KEY
## EC2 Container Repository
awsECR=YOUR_EC_REPOSITRY_URL
## Elastic beanstalk s3 deployment bucket
awsEBSBucket=YOUR_AWS_DEPLOYMENT_BUCKET_FOR_ELASTIC_BEANSTALK
## Elastic beanstalk config
awsEBSApp=YOUR_ELASTIC_BEANSTALK_APPLICATION_NAME
awsRegion=eu-central-1
```


###  Building project
```sh
gradle clean build -Penv=local
```

###  Starting embedded server
Server will be running on default port 8080
```sh
gradle startServer
```

### Starting unit tests:
```sh
gradle test
```

### Starting integration test with arquillian:
Before tests docker compose hast to be started because you may need an local
data store which you can run in docker.

Run compose once:
```sh
gradle dockerCompose
```
Then start tests:
```sh
gradle itest
```

###  Starting/stopping docker server
```sh
gradle startDocker
gradle stopDoker
```

###  Publishing to ecr repository
This command creates elastic beanstalk application deployment version 
and publish baked container to EC2 Container Repository:
```sh
gradle clean publishToECR -Penv=prod 
```

### Example running apps manually:

You can simply run them as jar applications or 
you can configure your ide to run jar application so you can debug it.

```sh
gradle build -Penv=local
java -jar ./pajara-micro.jar --deploy ./build/libs/starter-1.0.0.war
```
note if you did not download payara micro run 
```sh
gradle downloadPayaraMicro
```





