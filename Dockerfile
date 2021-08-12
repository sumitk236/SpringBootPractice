FROM openjdk:8
EXPOSE 8080
ADD target/springboot-practice.jar springboot-practice.jar
ENTRYPOINT ["java","-jar","/springboot-practice.jar"]
