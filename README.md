# gRPC + Kotlin + Spring Boot Example

Este proyecto demuestra cómo configurar y usar gRPC con Kotlin en una aplicación Spring Boot. El servicio gRPC implementado es un servicio simple que devuelve la información de un usuario a partir de una solicitud.

## **Requisitos**

- **JDK 11+**
- **Maven 3.x+**
- **gRPC** (https://grpc.io/)
- **Spring Boot** (https://spring.io/projects/spring-boot)
- **Kotlin** (https://kotlinlang.org/)

## **Tecnologías Usadas**

- Kotlin
- Spring Boot
- gRPC
- Protocol Buffers (Protobuf)
- Maven para gestión de dependencias y construcción

---

## **Instrucciones para Ejecutar el Proyecto**

### **1. Clonar el Repositorio**

Primero, clona el repositorio en tu máquina local:

```bash
git clone https://github.com/BillyBohren/exercise1.git

```

## **2. Construir el Proyecto**

Usa Maven para construir el proyecto. Asegúrate de tener Maven instalado y configurado correctamente:

```bash
mvn clean install
```

### **3. Ejecutar la Aplicación**

Para ejecutar la aplicación Spring Boot, usa el siguiente comando:

```bash
mvn spring-boot:run
```
### **4. Probar el Servicio gRPC**

El servidor gRPC se ejecuta en `localhost:9090`, y puedes probarlo utilizando herramientas como **gRPCurl** o **BloomRPC**.

#### **Usando gRPCurl**:

Para hacer una solicitud `GetUser` desde la línea de comandos con `gRPCurl`, puedes usar el siguiente comando:

```bash
grpcurl -plaintext -d '{"user_id":"123"}' localhost:9090 com.backend.exercise1.grpc.UserService/GetUser
```

O puedes usar BloomRpc si prefieres usar una interfaz grafica


Nota: En el archivo principal generado por proto UserServiceGrpc.java, tienes que reemplazar javax por jakarta (linea 7), una vez ejecutados los comandos mvn clean install o mvn clean compile antes de correr el proyecto.
El proyecto ya tiene un archivo que prueba el servicio y al iniciarlo se debe inprimir el resultado de la prueba