FROM openjdk:18
ADD target/*jar-with-dependencies.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]

#FROM openjdk:17-oracle
#VOLUME /tmp
#COPY .target/*jar-with-dependencies.jar app.jar
#ADD target/*jar-with-dependencies.jar app.jar
#EXPOSE 8082
#ENTRYPOINT ["java",  "-jar", "/app.jar"]