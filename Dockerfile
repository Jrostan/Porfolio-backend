FROM amazoncorretto:17-alpine-jdk //de que imagen JAVA partimo
MAINTAINER Jrostan //propietario
COPY target/porfolio-yo-programo-0.0.1-SNAPSHOT.jar  porfolio-jrostan.jar //copia desde nuestro proyecto (github) y lo sube  el segundo es el nombre de salida
ENTRYPOINT ["java","-jar","/porfolio-jrostan.jar"] //una vez creado el empaqueteado indica que es lo primero(instruccion) que se ejecuta