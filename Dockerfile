FROM payara/micro
WORKDIR /opt
EXPOSE 8080
ADD app.war application.war
ENTRYPOINT java -jar /opt/payara/payara-micro.jar --deploy application.war
