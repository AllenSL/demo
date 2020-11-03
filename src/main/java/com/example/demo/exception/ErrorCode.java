package com.example.demo.exception;

/**
 * @author fuyao
 * @decription: ErrorCode
 * @date: 2019/5/6 14:12
 */
public enum ErrorCode {
    //正常处理,
    EC_OK(200, "ok"),
    //客户端请求错误,
    EC_CLIENT_EXCEPTION(40, "非法请求"),
    EC_ISNAME_PASSWD_NOT_MATCH(41, "账号或密码错误"),
    EC_PARM_NULL(42, "参数不能为空"),
    EC_TEL_NULL(43, "账号不能为空"),
    EC_PWD_NULL(44, "密码不能为空"),
    ACCESSTOKEN_ERROE(45, "accessToken错误"),

    //服务端处理错误
    EC_SERVER_EXCEPTION(50, "系统异常,稍后再试"),
    EC_LOGOUT_EXCEPTION(51, "登出失败"),

    //其他未知错误
    EC_ERROR(60, "程序异常"),
    //注册登录异常,
    EC_TOKEN_OUT_EXPIRE(4013, "操作已过期"),
    EC_UNAUTHORIZED(4014, "没有授权"),

    // 文档格式不正确
    EC_DOC_FORMAT(100, "文档格式不正确");

    private int code;
    private String desc;

    ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    ErrorCode() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 通过code获取对象
     */
    public ErrorCode getErrorCode(int code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getCode() == code) {
                return errorCode;
            }
        }
        return null;
    }
}
