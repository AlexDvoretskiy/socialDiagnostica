FROM alpine:latest
MAINTAINER Alexander Dvoretskiy <alexander.dvoretskiy@gmail.com>

RUN apk add openjdk11
ADD ./build/libs/auth-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-service.jar"]

EXPOSE 5000