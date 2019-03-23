FROM openjdk:latest
MAINTAINER Hendi Santika <hendisantika.@yahoo.co.id>
VOLUME /tmp
ADD hendisantika-api-0.0.1-SNAPSHOT.jar apiApp.jar
RUN sh -c 'touch /api_app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api_app.jar"]