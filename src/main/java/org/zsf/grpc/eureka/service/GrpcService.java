package org.zsf.grpc.eureka.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.zsf.grpc.eureka.configure.GrpcConfig;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * description
 *
 * @author xxx 2019/01/15 19:19
 */
@Service
public class GrpcService {

    private GrpcServerImplBase grpcServerImplBase;
    private Server server;

    public GrpcService(GrpcConfig grpcConfig) {
        if (grpcServerImplBase == null) {
            grpcServerImplBase = new GrpcServerImplBase();
        }

        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(grpcConfig.getServerPort());
        server = serverBuilder.addService(grpcServerImplBase).build();
        try {
            this.start();
//            this.blockUntilShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        }) {
            @Override
            public void run() {
                GrpcService.this.stop();
            }
        });
    }


    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }


    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
