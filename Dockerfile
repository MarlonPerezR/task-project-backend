# Usar una imagen base de Java
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR (ajusta el nombre según tu proyecto)
COPY target/*.jar app.jar

# Exponer el puerto que usa Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]