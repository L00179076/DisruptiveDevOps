FROM openjdk:21
EXPOSE 8090
ADD target/maven-demo.jar maven-demo.jar
ENTRYPOINT ["java","-jar","/maven-demo.jar"]