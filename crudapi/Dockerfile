FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/crudapi-0.0.1-SNAPSHOT.war

# cd /opt/app
WORKDIR /opt/app

# cp target/crudapi-0.0.1-SNAPSHOT.war /opt/app/crudapi.war
COPY ${JAR_FILE} crudapi.war

# java -jar /opt/app/app.war
ENTRYPOINT ["java","-jar","app.war"]