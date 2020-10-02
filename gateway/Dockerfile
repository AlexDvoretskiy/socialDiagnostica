FROM alpine:latest
MAINTAINER Alexander Dvoretskiy <alexander.dvoretskiy@gmail.com>

RUN apk add openjdk11
ADD ./build/libs/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway.jar"]

EXPOSE 8080