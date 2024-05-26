## gRPC

This module contains articles about gRPC

## Introduction

gRPC is a high-performance, open-source universal RPC framework, initially developed by Google. 
It is based on HTTP/2, Protocol Buffers, and other modern technologies. gRPC is designed to be efficient, fast, 
and language-independent.

It is used to build APIs that connect services in and across data centers.

## Overview

gRPC can use protocol buffers as both its Interface Definition Language (IDL) and as its underlying message interchange format.
In gRPC, a client application can directly call methods on a server application on a different machine as if it were a local object,
making it easier for you to create distributed applications and services. As in many RPC systems, gRPC is based around the idea of defining a service,
specifying the methods that can be called remotely with their parameters and return types. On the server side, the server implements this interface and runs a gRPC server to handle client calls.
On the client side, the client has a stub (referred to as just a client in some languages) that provides the same methods as the server.

## Protocol Buffers

Protocol Buffers are a language-neutral, platform-neutral, extensible mechanism for serializing structured data.
It's like JSON, except it's smaller and faster, and it generates native language bindings for multiple languages.

Protocol buffers are a combination of 
1. the definition launguage (created in .proto files);
2. the code that the proto compiler generates to interface with data;
3. launguage-sepcific runtime libraries;
4. the serialization format for data that is written to a file(or sent across a network connection);
5. the serialized data.

## Benefits of Using Protocol Buffers
Protocol buffers are ideal for any situation in which you need to serialize structured, record-like, 
typed data in a language-neutral, platform-neutral, extensible manner.

1. Compact data storage;
2. Fast parsing;
3. Availability in many programming languages;
4. Optimized functionality through automatically-generated classes.

## Steps to create a typical client-server application using gRPC
1. Define the service in a .proto file;
2. Generate server and client code using the protocol buffer compiler;
    
    ```shell
    protoc --java_out=generated --grpc_out=generated --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java --proto_path=src/main/resources/protos src/main/resources/protos/hello.proto
    ```
    
    The `protoc` command generates the Java code for the service interfaces and the message classes. 
    The `--java_out` flag specifies the output directory for the generated Java code. 
    The `--grpc_out` flag specifies the output directory for the generated gRPC code. 
    The `--plugin` flag specifies the plugin that generates the gRPC code. 
    The `--proto_path` flag specifies the directory where the .proto file is located.
    
    The generated code includes the service interfaces, the message classes, and the gRPC server and client stubs.

Alternatively, you can use the `protobuf-maven-plugin` to generate the code.(in this example)

3. Create the server application, implementing the generated service interfaces and spawning the gPRC server;
4. Create the client application, making RPC calls using generated stubs.

## Types of gRPC
1. Unary RPC: The client sends a single request to the server and gets a single response back, just like a normal function call.
2. Server streaming RPC: The client sends a request to the server and gets a stream to read a sequence of messages back. 
The client reads from the returned stream until there are no more messages.
3. Client streaming RPC: The client writes a sequence of messages and sends them to the server, again using a provided stream.
4. Bidirectional streaming RPC: Both sides send a sequence of messages using a read-write stream.

### Relevant Articles:

- [Introduction to gRPC](https://www.baeldung.com/grpc-introduction)
- [Streaming with gRPC in Java](https://www.baeldung.com/java-grpc-streaming)
- [Error Handling in gRPC](https://www.baeldung.com/grpcs-error-handling)
- [Configuring Retry Policy for gRPC Request](https://www.baeldung.com/java-gprc-retry-policy)
- [Add Global Exception Interceptor in gRPC Server](https://www.baeldung.com/grpc-server-global-exception-interceptor)
