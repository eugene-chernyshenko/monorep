FROM amazoncorretto:11.0.12-alpine as builder

# RUN wget https://services.gradle.org/distributions/gradle-7.1.1-bin.zip && \
#     mkdir /opt/gradle && \
#     unzip -d /opt/gradle gradle-7.1.1-bin.zip && \
#     ln -s /opt/gradle/gradle-7.1.1/bin/gradle /usr/local/bin/gradle && \
#     rm gradle-7.1.1-bin.zip

WORKDIR /app

ADD . .

RUN ./gradlew build
# RUN gradle build

RUN name=$(./gradlew properties | grep ^name | awk '{print $2}') && \
    version=$(./gradlew properties | grep ^version | awk '{print $2}') && \
    cp build/libs/$name-$version.jar app.jar

# RUN name=$(gradle properties | grep ^name | awk '{print $2}') && \
#     version=$(gradle properties | grep ^version | awk '{print $2}') && \
#     cp build/libs/$name-$version.jar app.jar

FROM amazoncorretto:11.0.12-alpine

WORKDIR /app

COPY --from=builder /app/app.jar .

CMD ["java", "-jar", "/app/app.jar"]
