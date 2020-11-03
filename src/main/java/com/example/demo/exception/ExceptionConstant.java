package com.example.demo.exception;

/**
 * @ClassName ExceptionConstant
 * @Description 异常编码类
 * @Autor ansonglin
 * @Date 2019/5/7 9:19
 * @Version 1.0
 **/
public class ExceptionConstant {

    /******系统异常常量*******/
    //云服务配置异常
    public static final int CONFIG_ERROR_CODE = 100;
    //文件类型不支持异常
    public static final int FILETYPE_ERROR_CODE = 101;
    //上传文件超过配置值
    public static final int FILESIZE_ERROR_CODE = 102;
    //未处理异常
    public static final int SERVER_ERROR_CODE = 500;
    //参数校验异常
    public static final int CHECKFAIL_ERROR_CODE = 401;
}
   