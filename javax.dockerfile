# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="carlos.jafet@ateliware.com"

# Make port 8080 available to the world outside this container
EXPOSE 5000

COPY ./out/production/resources /usr/src/myapp

WORKDIR /usr/src/myapp

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","reactive-webflux.jar"]