FROM openjdk:17
ADD ../Docker-Jenkins/demo-0.0.1-SNAPSHOT.jar app1.jar
ENTRYPOINT [ "java", "-jar","app1.jar" ]
