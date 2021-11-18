package com.leyou.item.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leyou.common.api.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Description: 自定义限流 处理
 * @Author wb
 * @Date 2021/11/11 9:56
 */
public class CustomBlockHandler {

    public CommonResult<Void> handleException(BlockException exception){
        return CommonResult.failed(100,"流量限制");
    }
}
