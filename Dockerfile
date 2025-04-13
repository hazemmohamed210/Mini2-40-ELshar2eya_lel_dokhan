FROM openjdk:25-ea-4-jdk-oraclelinux9
WORKDIR /app
COPY /target .
CMD ["java", "-jar", "miniapp2.jar"]