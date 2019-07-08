FROM java:openjdk-8-jre
COPY ./build/libs /usr/src/myapp
WORKDIR /usr/src/myapp
#EXPOSE 5005
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","reactive-webflux.jar"]
CMD java -jar reactive-webflux-1.0-SNAPSHOT.jar