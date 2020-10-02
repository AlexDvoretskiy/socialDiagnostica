FROM alpine:latest
MAINTAINER Alexander Dvoretskiy <alexander.dvoretskiy@gmail.com>

RUN apk add openjdk11
ADD ./build/libs/social-diagnostica-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/social-diagnostica-service.jar"]

EXPOSE 8091