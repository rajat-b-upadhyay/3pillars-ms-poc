FROM openjdk:8-jdk-alpine
ADD target/mspoc-gateway-0.0.1-SNAPSHOT.jar mspoc-gateway.jar
ENTRYPOINT ["java", "-jar", "/mspoc-gateway.jar"]
EXPOSE 8082