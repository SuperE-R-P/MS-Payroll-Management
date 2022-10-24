FROM openjdk:8
ADD target/MicroservicePayrollManagement-1.0.jar MicroservicePayrollManagement-1.0.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "MicroservicePayrollManagement-1.0.jar"]