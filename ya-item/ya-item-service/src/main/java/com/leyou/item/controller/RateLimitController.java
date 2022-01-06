package com.leyou.item.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leyou.common.api.CommonResult;
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
   // @SentinelResource(value = "he",blockHandler = "ss")
    public CommonResult<String> byResource(){
        return CommonResult.success("按资源名称限流","success",200);
    }

    public CommonResult<Void> ss(BlockException ex){
        System.err.println(ex.getMessage());
        System.err.println("限流");
        return CommonResult.failed(100,"被限流了哦");
    }
}
