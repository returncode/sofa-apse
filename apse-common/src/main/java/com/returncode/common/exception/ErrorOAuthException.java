package com.returncode.common.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 统一认证错误异常
 *
 * @Author: wanglei
 * @Date: 2020/5/18
 */
@JsonSerialize(using = ErrorOAuthExceptionSerializer.class)
public class ErrorOAuthException extends OAuth2Exception {

    private int status;
    private String error;

    public ErrorOAuthException(String msg, Throwable t) {
        super(msg, t);
    }

    public ErrorOAuthException(String msg) {
        super(msg);
    }

    public ErrorOAuthException(int status, String error, String msg) {
        super(msg);
        this.status = status;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
