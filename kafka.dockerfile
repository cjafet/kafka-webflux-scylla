FROM java:openjdk-8-jre
COPY ./kafka /var/www/kafka
COPY ./build/libs /var/www
WORKDIR /var/www/
# RUN ./kafka/bin/zookeeper-server-start.sh ./kafka/config/zookeeper.properties 
# ENV KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
# ENV KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:29092
CMD ./kafka/bin/zookeeper-server-start.sh ./kafka/config/zookeeper.properties ; ./kafka/bin/kafka-server-start.sh ./kafka/config/server.properties ; java -jar reactive-webflux-1.0-SNAPSHOT.jar 
# ENTRYPOINT ["",""]
