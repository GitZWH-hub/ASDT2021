FROM openjdk:8-jre-alpine3.9
VOLUME /tmp
ADD target/user-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 5002
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Xmx1024m","-Xms1024m","/app.jar"]

