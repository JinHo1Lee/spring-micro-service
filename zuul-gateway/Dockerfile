FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/zuul-gateway-0.0.1-SNAPSHOT.jar /
ENTRYPOINT exec java $JAVA_OPTS -jar zuul-gateway-0.0.1-SNAPSHOT.jar 
