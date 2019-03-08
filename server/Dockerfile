FROM gradle:5.2.1-jdk11

WORKDIR /server
ADD . /server

EXPOSE 8081

RUN gradle bootJar

ENTRYPOINT java -jar build/libs/server-0.0.1-SNAPSHOT.jar

