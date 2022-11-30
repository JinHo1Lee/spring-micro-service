package com.example.service;

import org.springframework.stereotype.Service;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.grpc.lib.HelloReply;
import net.grpc.lib.HelloRequest;
import net.grpc.lib.MapFieldEntry;
import net.grpc.lib.GreeterGrpc.GreeterBlockingStub;

@Service
public class GrpcClientService {
    @GrpcClient("grpc-auth-server")
    private GreeterBlockingStub greeterStub;

    public MapFieldEntry hello(final String name) {
        try {
            final HelloReply response =
                    this.greeterStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getResult();
        } catch (final StatusRuntimeException e) {
            return MapFieldEntry.newBuilder().setResult(false).build();
        }
    }
}
