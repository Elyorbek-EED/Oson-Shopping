FROM openjdk:17
ARG JAR_FILE=target/account-service-0.0.1-SNAPSHOT.jar
VOLUME /tmp
COPY target/${JAR_FILE} account-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","account-service-0.0.1-SNAPSHOT.jar"]
