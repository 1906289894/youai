package com.leyou.common.exception;

import lombok.Data;
import lombok.Getter;

@Getter
public class LyException extends RuntimeException{

    private int status;

    public LyException(int status) {
        this.status = status;
    }

    public LyException(int status, String message) {
        super(message);
        this.status = status;
    }

    public LyException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public LyException(int status, Throwable cause) {
        super(cause);
        this.status = status;
    }

}
