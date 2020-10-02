FROM alpine:latest
MAINTAINER Alexander Dvoretskiy <alexander.dvoretskiy@gmail.com>

RUN apk add openjdk11
ADD ./build/libs/discovery-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/discovery-service.jar"]

EXPOSE 8761