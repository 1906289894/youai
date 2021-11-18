package com.leyou.gateway.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 从nacos配置中心获取配置信息
 * @Author wb
 * @Date 2021/11/16 10:55
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
