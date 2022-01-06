package com.leyou.common.exception;


import com.leyou.common.api.CommonResult;
import com.leyou.common.api.IErrorCode;
import lombok.extern.log4j.Log4j2;

/**
 * @Description: 自定义API异常
 * @Author wb
 * @Date 2021/11/9 9:38
 */
@Log4j2
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }

    public static CommonResult<Void> fallback(Throwable e){
        log.error(e.getMessage());
        return CommonResult.failed("=====服务异常被降级了");
    }
}