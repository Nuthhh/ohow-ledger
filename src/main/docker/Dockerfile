FROM openjdk:8-jdk-alpine
ADD *.jar ohow-ledger.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/ohow-ledger.jar"]