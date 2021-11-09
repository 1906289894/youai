package com.leyou.common.handler;

import com.leyou.common.api.CommonResult;
import com.leyou.common.exception.ApiException;

/**
 * @Description: 自定义限流处理
 * @Author wb
 * @Date 2021/11/9 9:35
 */
public class CustomBlockHandler {
    public CommonResult<Void> HandleException(ApiException exception){
        return CommonResult.failed("自定义限流");
    }
}
