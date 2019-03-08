FROM openjdk:11-stretch

WORKDIR /server
ADD ./build/libs/ /server
EXPOSE 8081
CMD ["bash","-c","run.sh"]
