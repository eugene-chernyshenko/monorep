FROM maven:3.8.2-openjdk-11 as builder

WORKDIR /app

ADD . .

RUN mvn clean package

FROM tomcat:9.0-jdk11-temurin

WORKDIR /usr/local/tomcat

COPY --from=builder /app/target/demo/WEB-INF/web.xml ./conf/web.xml

COPY --from=builder /app/target/demo.war ./webapps/
