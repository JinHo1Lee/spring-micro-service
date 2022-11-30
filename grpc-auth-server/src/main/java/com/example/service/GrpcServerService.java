package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.stub.StreamObserver;

import net.devh.boot.grpc.server.service.GrpcService;
import net.grpc.lib.HelloReply;
import net.grpc.lib.HelloRequest;
import net.grpc.lib.MapFieldEntry;
import net.grpc.lib.GreeterGrpc.GreeterImplBase;

@GrpcService
public class GrpcServerService extends GreeterImplBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(GrpcServerService.class);
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "SERVER 1 - Hello" + request.getName();

        MapFieldEntry mapFieldEntry = MapFieldEntry.newBuilder()
                .setName(request.getName())
                .setResult(true)
                .build();

        final HelloReply.Builder replyBuilder = HelloReply.newBuilder().setResult(mapFieldEntry);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
        LOGGER.info("Server Returning:{}", message);
    }
}
