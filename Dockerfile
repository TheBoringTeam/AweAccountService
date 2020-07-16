FROM adoptopenjdk/openjdk11:alpine
MAINTAINER holkerdev
VOLUME /tmp
EXPOSE 8084
ADD target/music-0.0.1.jar music-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/music-service.jar"]