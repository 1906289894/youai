package com.leyou.common.api;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 统一返回封住
 * @Author wb
 * @Date 2021/11/9 9:38
 */
@Data
public class CommonResult<R> implements Serializable {
    private String message;
    private Integer code;
    private R data;

    protected CommonResult() {
    }

    protected CommonResult(String message, Integer code, R data) {
        super();
        this.message = message;
        this.code = code;
        this.data = data;
    }

    /**
     * 成功返回
     *
     * @param data 结果数据
     * @param <R>  obj
     * @return r
     */
    public static <R> CommonResult<R> success(R data) {
        return new CommonResult<>(ResultCode.SUCCESS.getMessage(), ResultCode.SUCCESS.getCode(), data);
    }

    /**
     * 成功返回
     *
     * @param data 结果数据
     * @param <R>  obj
     * @return r
     */
    public static <R> CommonResult<R> success(R data, String msg) {
        return new CommonResult<>(msg, ResultCode.SUCCESS.getCode(), data);
    }

    /**
     * 成功返回
     *
     * @param data 结果数据
     * @param <R>  obj
     * @return r
     */
    public static <R> CommonResult<R> success(R data, String msg, int code) {
        return new CommonResult<>(msg, code, data);
    }

    /**
     *  失败返回
     * @param errorCode 错误码
     * @param <R> r
     * @return result
     */
    public static <R> CommonResult<R> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getMessage(),errorCode.getCode(),null);
    }

    /**
     *  失败返回
     * @param errorCode 错误码
     * @param <R> r
     * @return result
     */
    public static <R> CommonResult<R> failed(IErrorCode errorCode,String message) {
        return new CommonResult<>(message,errorCode.getCode(),null);
    }

    /**
     *  失败返回
     * @param <R> r
     * @return result
     */
    public static <R> CommonResult<R> failed(String message) {
        return new CommonResult<>(message,ResultCode.FAILED.getCode(),null);
    }

    /**
     *  失败返回
     * @param <R> r
     * @return result
     */
    public static <R> CommonResult<R> failed() {
        return failed(ResultCode.FAILED);
    }
}
