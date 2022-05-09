package com.leyou.common.advace;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 统一异常处理办法
     * @ExceptionHandler(RuntimeException.class)声明这个方法处理RuntimeException这样的异常
     * @Param e 捕获的异常
     * return 返回的状态码和信息
     */
    @ExceptionHandler
    public ResponseEntity<String> handleLyException(RuntimeException e){

        return ResponseEntity.status(400).body(e.getMessage());
    }
}
