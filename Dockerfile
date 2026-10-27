# Etapa de compilación con Java 25
FROM eclipse-temurin:25-jdk-alpine AS build
WORKDIR /app

# Copiamos todo el repositorio
COPY . .

# Entramos a la subcarpeta donde está el proyecto Spring Boot
WORKDIR /app/edunova-spring/edunova-spring

# Damos permisos de ejecución al Maven Wrapper
RUN chmod +x mvnw

# Compilamos el proyecto con Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución final con Java 25 (JRE)
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Copiamos el JAR generado desde la subcarpeta hacia la raíz del contenedor
COPY --from=build /app/edunova-spring/edunova-spring/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]