package com.gary.grpc.server;

import com.gary.grpc.HelloRequest;
import com.gary.grpc.HelloResponse;
import com.gary.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase{

    /**
     * This method is called by the client when it wants to say hello
     *
     * @param request The request from the client.  It is the same as the contract defined in proto file
     * @param responseObserver a response observer, which is a call back for the server to call with its response
     */
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Request received from client: \n" + request);

        String greeting = new StringBuilder().append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
