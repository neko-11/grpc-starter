package org.zsf.grpc.eureka.service.handler;

/**
 * 接收处理方法
 *
 * @author xxx 2019/01/16 14:18
 */
public interface GrpcHandler {

    /**
     * 接收请求处理方法
     *
     * @param param 参数
     * @return 返回参数
     */
    String execute(String param);
}
