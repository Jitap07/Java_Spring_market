# Construcción (build) de la Imagen JAVA en un contenedor (Docker):
# Proporciona el entorno necesario para compilar el código Java, ya que para Java 21 o posteriores, No esta disponible en Railway (no compatible por ahora).
FROM eclipse-temurin:22-jdk as build

# Copia los archivos del proyecto, al directorio "/app" dentro del contenedor.
COPY . /app

# Establece "/app" como directorio de trabajo:
WORKDIR /app

# Da permisos de ejecución al script "mvnw", permitiendo que se ejecute durante la construcción del contenedor:
RUN chmod +x mvnw

# Compilación del codigo con "mvnw" y generación del ".jar" usando el ciclo de vida "package" de MAVEN, saltándose las pruebas.
# Nota: Por defecto, el ".jar" se crea dentro del directorio "target", sino existiera, se crea y dentro genera el ".jar":
RUN ./mvnw package -DskipTests

# Busca y mueve el ".jar" generado de "target/*.jar" al directorio de trabajo "/app" (al no especificar el directorio destino, se toma el actual)
# Y lo renombra a "app.jar":
RUN mv -f target/*.jar app.jar

# Usa la imagen creada o construida, para ejecutar la aplicación:
FROM eclipse-temurin:22-jre

# Definiendo variable "PORT":
ARG PORT

# Asignar el valor del puerto dado por Railway durante la construcción del contenedor:
ENV PORT=${PORT}

# Permite copiar el ".jar" generado en el contenedor "build" al contenedor actual:
COPY --from=build /app/app.jar .

# Crea un usuario "runtime":
RUN useradd runtime

# Cambia el usuario actual a "runtime", para ejecutar comandos con permisos limitados:
USER runtime

# Estructura del Comando que permite ejecutar un ".jar" por consola (Ejm: java -Dserver.port=8080 -jar app.jar)
ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]
