# monorep

## services

- service-a - spring-boot java application with gradle
- service-b - tomcat java application with maven

## build and run localy

service-a

```
cd service-a
docker-compose build
docker-compose up -d
curl -sS http://127.0.0.1:8080/hello
```

service-b

```
cd service-b
docker-compose build
docker-compose up -d
curl -sS http://127.0.0.1:8080/demo/hello
```

## overriding configs

service-a

uncoment these lines in the docker-compose.yaml

```
    command: java -Dspring.config.additional-location=file:/appconfigs/ -jar /app/demo.jar
    volumes:
    - ../configuration/service-a:/appconfigs
```

service-b

uncoment these lines in the docker-compose.yaml

```
    command: /entrypoint.sh
    volumes:
    - ../configuration/service-b:/appconfigs
    - ./entrypoint.sh:/entrypoint.sh
```
