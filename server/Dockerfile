FROM openjdk:11-stretch

WORKDIR /server
ADD ./build/libs/ /server
ADD ./*.sh /server
RUN chmod +x ./*.sh
EXPOSE 8081
CMD ["bash","-c","run.sh"]
