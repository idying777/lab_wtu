FROM openjdk:11-stretch

WORKDIR /server
ADD ./build/libs/ /server
EXPOSE 8081
ENTRYPOINT java -jar server-0.0.1-SNAPSHOT.jar
