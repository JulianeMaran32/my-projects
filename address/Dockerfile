FROM eclipse-temurin:21-jdk

VOLUME /tmp

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/address-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/app/address-0.0.1-SNAPSHOT.jar"]