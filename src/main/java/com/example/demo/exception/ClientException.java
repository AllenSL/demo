package com.example.demo.exception;


/**
 * @author fuyao
 * @ClassName BaseRuntimeException
 * @Description 客户端异常
 * @Date 2019/5/9 9:32
 * @Version 1.0
 **/
public class ClientException extends BaseRuntimeException {

    private static final long serialVersionUID = -4928804721927939749L;

    public ClientException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ClientException(String msg, Exception e) {
        super(msg, e);
    }
}
