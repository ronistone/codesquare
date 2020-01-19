FROM maven:3.6.3-jdk-8-slim

RUN mkdir /c /m && ln -s /m ~/.m2

WORKDIR /c

CMD [ "mvn", "spring-boot:run" ]