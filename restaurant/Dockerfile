FROM java:8-jre
WORKDIR usr/src
ADD ./target/restaurant-0.0.1-SNAPSHOT.jar /usr/src/restaurant-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","restaurant-0.0.1-SNAPSHOT.jar"]