FROM openjdk:18
VOLUME /tmp
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]