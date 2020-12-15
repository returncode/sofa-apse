package com.returncode.apseboot.common.exception;

/**
 * 统一错误结果异常
 */
public class ErrorResultException extends RuntimeException {

    private int status;
    private String error;
    private String message;

    public ErrorResultException(String message) {
        this(500, message);
    }

    public ErrorResultException(int status, String message) {
        this(status, "Internal Server Error", message);
    }

    public ErrorResultException(int status, String error, String message) {
        super(message);
        this.status = status;
        this.error = error;
        this.message = message;
    }


    public ErrorResultException(int status, String error, String message, Throwable t) {
        super(message, t);
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
