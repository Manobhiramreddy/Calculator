FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY Calculator.java .
RUN mkdir -p build \
    && javac -d build Calculator.java \
    && echo "Main-Class: Calculator" > manifest.txt \
    && jar cfm calculator.jar manifest.txt -C build .
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/calculator.jar .
CMD ["java", "-jar", "calculator.jar"]

