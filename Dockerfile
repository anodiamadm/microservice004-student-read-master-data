FROM openjdk:11
EXPOSE 8447
ADD target/microservice004-student-read-master-data.jar microservice004-student-read-master-data.jar
ENTRYPOINT ["java","-jar","/microservice004-student-read-master-data.jar"]