package com.leyou.common.utils.exception;

import com.leyou.common.api.CommonResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常处理
 * @Author wb
 * @Date 2021/11/9 9:38
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult<Void> handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<Void> handleValidException(MethodArgumentNotValidException e) {
        return handleException(e.getBindingResult());
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public CommonResult<Void> handleValidException(BindException e) {
        return handleException(e.getBindingResult());
    }

    public CommonResult<Void> handleException(BindingResult bindingResult){
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return CommonResult.failed(message);
    }
}