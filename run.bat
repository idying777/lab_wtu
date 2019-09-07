call back-end/gradlew -b back-end/build.gradle bootJar > NUL
docker-compose up --build %1
