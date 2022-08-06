FROM openjdk:17
ARG JAR_FILE=target/discovery-service-0.0.1-SNAPSHOT.jar
VOLUME /tmp
COPY target/${JAR_FILE} discovery-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","discovery-service-0.0.1-SNAPSHOT.jar"]
