FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/view-service-0.0.1-SNAPSHOT.jar view-app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /view-service-app.jar" ]
