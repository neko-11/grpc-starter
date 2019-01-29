package org.zsf.grpc.eureka.client;

import org.demo.grpc.eureka.lib.GreeterGrpc;
import org.demo.grpc.eureka.lib.GrpcReply;
import org.demo.grpc.eureka.lib.GrpcRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * description
 *
 * @author xxx 2019/01/15 19:26
 */
@SuppressWarnings("unused")
public class GrpcClient {


    private String ip;
    private Integer port;

    public GrpcClient(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public String send(String param) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(ip, port).usePlaintext().build();
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(managedChannel);
        GrpcRequest request = GrpcRequest.newBuilder().setParam(param).build();
        GrpcReply reply = stub.getRequest(request);
        return reply.getResult();
    }
}