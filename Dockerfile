# Etapa de construcción
FROM maven:3.8.5-openjdk-17-slim as maven_image
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente y realiza la compilación
COPY src ./src

RUN mvn package -DskipTests

# Imprime el contenido de la carpeta target para verificar la generación del JAR
RUN ls /app/target

# Etapa de ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=maven_image /app/target/apirest-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "apirest-0.0.1-SNAPSHOT.jar"]