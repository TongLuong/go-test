FROM eclipse-temurin:17-jdk

WORKDIR /gos_service

COPY . .

RUN ./mvnw wrapper:wrapper \
 && ./mvnw dependency:go-offline \
 && ./mvnw clean install

CMD ["java", "-jar", "target/*.jar"]

EXPOSE 4000