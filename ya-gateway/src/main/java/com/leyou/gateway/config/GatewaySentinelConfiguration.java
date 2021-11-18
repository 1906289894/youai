package com.leyou.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class GatewaySentinelConfiguration {
    
    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;

    public GatewaySentinelConfiguration(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                        ServerCodecConfigurer serverCodecConfigurer) {
    
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }


    /**
     * 配置SentinelGatewayBlockExceptionHandler，限流后异常处理
     * @return sentinelGatewayBlockExceptionHandler
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
    
        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }

    // 自定义限流异常页面
    @PostConstruct
    public void initBlockHandlers() {
    
        BlockRequestHandler blockRequestHandler = (serverWebExchange, throwable) -> {
            Map<String,Object> result = new HashMap<>();
            result.put("message","false");
            result.put("code",100);
            result.put("info","接口被限流了");
            return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(result));
        };
        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }

    /**
     * 配置SentinelGatewayFilter
     * @return globalFilter
     */
    @Bean
    @Order(-1)
    public GlobalFilter sentinelGatewayFilter() {
    
        return new SentinelGatewayFilter();
    }
}