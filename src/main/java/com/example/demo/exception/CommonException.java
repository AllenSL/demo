package com.example.demo.exception;

/**
 * 通用异常类
 */
public class CommonException extends BaseRuntimeException {


    public CommonException(String msg) {
        super(9999, msg);
    }

    public CommonException(String msg, Throwable e) {
        super(msg, e);
    }

    public CommonException(int code, String msg) {
        super(code, msg);
    }

    public CommonException(int code, String msg, Throwable e) {
        super(code, msg, e);
    }
}
