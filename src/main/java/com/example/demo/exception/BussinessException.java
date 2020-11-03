package com.example.demo.exception;

/**
 * @ClassName BussinessException
 * @Description 业务异常类
 * @Autor ansonglin
 * @Date 2019/5/7 9:20
 * @Version 1.0
 **/
public class BussinessException extends BaseRuntimeException {

    public BussinessException(String msg) {
        super(msg);
    }

    public BussinessException(String msg, Throwable e) {
        super(msg, e);
    }

    public BussinessException(int code, String msg) {
        super(code, msg);
    }

    public BussinessException(int code, String msg, Throwable e) {
        super(code, msg, e);
    }
}
   