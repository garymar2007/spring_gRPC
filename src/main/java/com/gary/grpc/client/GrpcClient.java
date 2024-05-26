package com.gary.grpc.client;

import com.gary.grpc.HelloRequest;
import com.gary.grpc.HelloResponse;
import com.gary.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * This is the client class that will send a request to the server
 * and receive a response back
 * NB: The stub is the primary way for clients to interact with the server.
 *
 * Here we're using a blocking/synchronous stub so that the RPC call waits for the server to respond,
 * and will either return a response or raise an exception.
 */
public class GrpcClient {
    public static void main(String[] args) {
        System.out.println("Hello from gRPC client");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse response = blockingStub.hello(HelloRequest.newBuilder()
                        .setFirstName("Gary")
                        .setLastName("Ma")
                        .build());
        System.out.println("Response received from server: \n" + response.getGreeting());
        channel.shutdown();
    }
}
