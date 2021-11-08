package com.leyou.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * IP地址类型的令牌桶生成
 */
@Configuration
public class KeyResolver {
    //定义一个keyResolver

    @Bean
    public KeyResolver ipKeyResolver(){

        return new KeyResolver(){
            public Mono<String> resolve(ServerWebExchange exchange){
                return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
            }
        };

        // JDK8 的Lambda写法：
        //return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());

    }
}
