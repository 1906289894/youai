package com.leyou.item.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.leyou.common.api.CommonResult;
import com.leyou.common.exception.ApiException;
import com.leyou.item.web.MyBlockExceptionHandler;
import com.sun.deploy.security.BlockedException;
import handler.MyUrlBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 限流功能
 * @Author wb
 * @Date 2021/11/9 10:44
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandlerClass = MyUrlBlockHandler.class)
    public CommonResult<String> byResource(){
        return CommonResult.success("按资源名称限流","success",200);
    }

    public CommonResult<Void> ss(BlockedException ex){
        return CommonResult.failed(ex.getMessage());
    }
}
