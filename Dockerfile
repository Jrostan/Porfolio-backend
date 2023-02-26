FROM amazoncorretto:11-alpine-jdk
MAINTAINER Jrostan
COPY target/porfolio-yo-programo-0.0.1-SNAPSHOT.jar porfolio-jrostan.jar
ENTRYPOINT ["java","-jar","/porfolio-jrostan.jar"]