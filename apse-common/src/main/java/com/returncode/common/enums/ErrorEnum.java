package com.returncode.common.enums;

/**
 * 错误异常枚举
 */
public enum ErrorEnum {
    /**
     * 数据结果为空
     */
    NULL_RESULT(5555, "Null Result Error", "数据结果为空"),
    /**
     * 用户名或密码错误
     */
    ACCOUNT_PWD_ERROR(5556, "Account Password Error", "用户名或密码错误"),
    /**
     * 服务器未知错误
     */
    UNDEFINED_EXCEPTION(5599, "Server Undefined Exception", "服务器未知错误");

    private int state;
    private String error;
    private String message;

    ErrorEnum(int state, String error, String message) {
        this.state = state;
        this.error = error;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
