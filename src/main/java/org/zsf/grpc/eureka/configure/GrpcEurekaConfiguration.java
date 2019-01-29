package org.zsf.grpc.eureka.configure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zsf.grpc.eureka.service.GrpcService;

/**
 * @author xxx 2019/01/16 14:06
 */
@Configuration
public class GrpcEurekaConfiguration {

    private GrpcConfig grpcConfig;

    @Bean
    @ConditionalOnMissingBean
    public GrpcConfig grpcConfig() {
        grpcConfig = new GrpcConfig();
        return grpcConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public GrpcService grpcService() {
        return new GrpcService(grpcConfig);
    }
}