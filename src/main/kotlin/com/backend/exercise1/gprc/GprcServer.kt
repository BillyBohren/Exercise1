package com.backend.exercise1.gprc

import com.backend.exercise1.grpc.GetUserRequest
import com.backend.exercise1.grpc.UserResponse
import com.backend.exercise1.grpc.UserServiceGrpc

import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class UserService : UserServiceGrpc.UserServiceImplBase() {

    override fun getUser(request: GetUserRequest, responseObserver: StreamObserver<UserResponse>) {
        println("Request recibido en servidor gRpc para User ID: ${request.userId}")

        // Respuesta hardcodeada
        val response = UserResponse.newBuilder()
            .setUserId(request.userId)
            .setName("Alice")
            .setEmail("alice@example.com")
            .build()

        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}

fun main() {
    val port = 9090
    val server: Server = ServerBuilder.forPort(port)
        .addService(UserService())
        .build()
        .start()

    Runtime.getRuntime().addShutdownHook(Thread {
        server.shutdown()
    })

    server.awaitTermination()
}