FROM gradle:8.12.1-jdk21-alpine AS builder

ARG HOME_DIR="/home/app"
WORKDIR $HOME_DIR

COPY src src/
COPY build.gradle settings.gradle ./

RUN gradle assemble

FROM amazoncorretto:21-alpine3.21

WORKDIR /app

COPY --from=builder /home/app/build/libs/fastfood-payments-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
