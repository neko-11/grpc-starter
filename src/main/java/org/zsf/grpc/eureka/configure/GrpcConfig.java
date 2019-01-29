package org.zsf.grpc.eureka.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * grpc配置
 *
 * @author xxx 2019/01/16 14:06
 */
@Component
@ConfigurationProperties(prefix = "grpc")
public class GrpcConfig {

    /**
     * 监听端口号
     */
    private Integer serverPort = 9999;

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * 服务组名称
     */
    public class Eureka {
        private String serviceId;

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }
    }
}