package com.gary.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * This is the server class that will start the gRPC server
 * and listen for incoming requests from the client
 * and respond back with a greeting
 */
public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
