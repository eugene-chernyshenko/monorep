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
