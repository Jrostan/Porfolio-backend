FROM amazoncorretto:17-alpine-jdk
MAINTAINER Jrostan
COPY target/porfolio-yo-programo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/porfolio-jrostan.jar"]