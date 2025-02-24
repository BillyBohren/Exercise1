package com.backend.exercise1.gprc

import com.backend.exercise1.grpc.GetUserRequest
import com.backend.exercise1.grpc.UserServiceGrpc
import io.grpc.ManagedChannelBuilder
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GrpcClientRunner {

    @Bean
    fun runGrpcClient(): ApplicationRunner {
        return ApplicationRunner {
            Thread {
                try {
                    println("Ejecutando prueba gRPC...")
                    val channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                        .usePlaintext()
                        .build()
                    val stub = UserServiceGrpc.newBlockingStub(channel)
                    val request = GetUserRequest.newBuilder()
                        .setUserId("123")
                        .build()
                    val response = stub.getUser(request)
                    println("Respuesta recibida: $response")
                    channel.shutdown()
                } catch (e: Exception) {
                    println("Error ejecutando la prueba gRPC: ${e.message}")
                }
            }.start()
        }
    }
}