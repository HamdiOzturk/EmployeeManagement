FROM openjdk:8-jdk-alpine
COPY target/employee-management.jar employee-management.jar
ADD entrypoint.sh entrypoint.sh
ENTRYPOINT ["java", "-jar", "/employee-management.jar"]
