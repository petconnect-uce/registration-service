# Imagen base de OpenJDK 21 con JDK
FROM eclipse-temurin:21-jdk

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el jar de la aplicación
COPY target/registration-service-0.0.1-SNAPSHOT.jar app.jar

# Puerto expuesto
EXPOSE 8082

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
