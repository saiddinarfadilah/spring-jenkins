# Stage 1 : Base Image Maven
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
ADD ./pom.xml /app
ADD ./src /app/src/
RUN mvn clean package -DskipTest

# Stage 2 : Base Image SDK Java:17
FROM openjdk:17-slim
WORKDIR /app
COPY --from=builder /app/target/spring-jenkins-1.0.0.jar /app/spring-jenkins-1.0.0.jar
EXPOSE 8080
ENV TZ=Asia/Jakarta
ENTRYPOINT ["java","-XX:+UseG1GC","-jar","/app/spring-jenkins-1.0.0.jar"]