FROM amazoncorretto:11.0.12-alpine as builder

WORKDIR /app

ADD . .

RUN ./gradlew build

RUN name=$(./gradlew properties | grep ^name | awk '{print $2}') && \
    version=$(./gradlew properties | grep ^version | awk '{print $2}') && \
    cp build/libs/$name-$version.jar app.jar

FROM amazoncorretto:11.0.12-alpine

WORKDIR /app

COPY --from=builder /app/app.jar .

CMD ["java", "-jar", "/app/app.jar"]
