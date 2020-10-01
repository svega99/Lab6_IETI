FROM openjdk:8
COPY "build/libs/*.jar" "app.jar"
ENTRYPOINT ["java","-Dserver.port=${PORT}","-jar","app.jar"]