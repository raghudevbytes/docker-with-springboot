ARG version=17-slim-buster
FROM openjdk:${version}
LABEL maintainer="tester@gmail.com"
WORKDIR /usr/src
COPY target/user-1.0.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","user-1.0.jar"]