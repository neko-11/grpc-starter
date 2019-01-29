package org.zsf.grpc.eureka.service;

import java.util.Map;

import org.demo.grpc.eureka.lib.GreeterGrpc;
import org.demo.grpc.eureka.lib.GrpcReply;
import org.demo.grpc.eureka.lib.GrpcRequest;
import org.zsf.grpc.eureka.helper.ApplicationContextHelper;
import org.zsf.grpc.eureka.service.handler.GrpcHandler;

import io.grpc.stub.StreamObserver;

/**
 * 接受请求
 *
 * @author xxx 2019/01/15 19:09
 */
public class GrpcServerImplBase extends GreeterGrpc.GreeterImplBase {

    @Override
    public void getRequest(GrpcRequest request, StreamObserver<GrpcReply> responseObserver) {
        Map<String, GrpcHandler> beansOfType = ApplicationContextHelper.getContext().getBeansOfType(GrpcHandler.class);
        beansOfType.forEach((name, bean) -> {
            GrpcReply reply = GrpcReply.newBuilder().setResult(bean.execute(request.getParam())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        });
    }
}
