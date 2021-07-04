FROM openjdk:12
ADD target/hotelbooking-0.0.1-SNAPSHOT.jar hotelbooking-0.0.1-SNAPSHOT.jar
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} hotelbooking-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","hotelbooking-0.0.1-SNAPSHOT.jar"]