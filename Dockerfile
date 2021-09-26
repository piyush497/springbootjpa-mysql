FROM openjdk:8
ADD target/springbootjpa-0.0.1-SNAPSHOT.jar  springbootjpa-0.0.1-SNAPSHOT.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "springbootjpa-0.0.1-SNAPSHOT.jar"]