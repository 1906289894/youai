package com.leyou.gateway.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    /**
     * 默认的超时降级处理页面
     */
    public ResponseEntity<String> fallBackController(){
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("请求超时");
    }
}
