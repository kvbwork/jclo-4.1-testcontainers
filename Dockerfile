FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8081
ADD build/libs/springBootDemo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
