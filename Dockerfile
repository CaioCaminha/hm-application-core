FROM openjdk:11-jdk
VOLUME /tmp

RUN useradd -d /home/caiocaminha -m -s /bin/bash caiocaminha
USER caiocaminha

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]