package com.qiding.jiaguo.common.constant;

public enum  ErrorCode {
    SUCCESS(0,"success"),
    SMS_CODE_ERROR(10000,"activeCode错误"),
    PASSWORD_USE_NAME_ERROR(10001,"用户名或者密码错误"),
    UN_KNOW_ERROR(-1,"服务器未知异常");



    private  int code;
    private  String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
