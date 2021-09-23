FROM amazoncorretto:11.0.12-alpine as builder

WORKDIR /app

ADD . .

RUN ./gradlew build

RUN version=$(./gradlew properties | grep ^version | awk '{print $2}') && \
    cp "build/libs/demo-${version}.jar" demo.jar

FROM amazoncorretto:11.0.12-alpine

WORKDIR /app

COPY --from=builder /app/demo.jar .

CMD ["java", "-jar", "/app/demo.jar"]
