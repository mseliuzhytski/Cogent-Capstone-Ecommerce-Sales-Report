FROM openjdk:17-jdk-alpine
ADD target/ecommerce-sales-report-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["sh","-c","java -jar /app.jar"]