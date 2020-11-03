package com.example.demo.base.util;

import java.io.Serializable;

public abstract class ResultUtil implements Serializable {
    private static final long serialVersionUID = -7461152521445512321L;

    /**
     * 默认成功编码
     */
    public static final int DEFAULT_SUCC_CODE = 0;
    /**
     * 默认失败编码--系统错误
     */
    public static final int DEFAULT_FAIL_CODE = 9999;

    public static ResultInfo success(){
        return success(null,null);
    }

    public static ResultInfo success(Object resultData){
        return success(null,resultData);
    }

    public static ResultInfo success(String message,Object resultData){
        ResultInfo result = new ResultInfo();
        result.setCode(DEFAULT_SUCC_CODE);
        result.setMsg(message);
        result.setData(resultData);
        return result;
    }

    public static ResultInfo error(int errorCode,String message){
        ResultInfo result = new ResultInfo();
        result.setCode(errorCode);
        result.setMsg(message);
        return result;
    }
    public static ResultInfo error(String message){
        ResultInfo result = new ResultInfo();
        result.setCode(500);
        result.setMsg(message);
        return result;
    }
}
