FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/config-service-0.0.1-SNAPSHOT.jar config-service-app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /config-service-app.jar" ]
