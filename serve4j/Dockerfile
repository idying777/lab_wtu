## build stage
#FROM gradle:5.2.1-jdk11 as build-stage
#WORKDIR /app
#COPY --chown=gradle . .
#RUN gradle bootJar
#
## production stage
#FROM openjdk:11-stretch as production-stage
#COPY --from=build-stage /app/build/libs/server-0.0.1-SNAPSHOT.jar app.jar

FROM openjdk:11-stretch
COPY ./build/libs/serve4j-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
