package com.returncode.common.result;

import com.returncode.common.enums.ErrorEnum;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class ErrorResult extends Result {

    private String error;
    private String message;

    public ErrorResult(HttpServletRequest request, HttpStatus httpStatus, String message) {
        super(new Date(), httpStatus.value(), request.getRequestURI());
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
    }

    public ErrorResult(HttpServletRequest request, ErrorEnum errorEnum, String message) {
        super(new Date(), errorEnum.getState(), request.getRequestURI());
        this.error = errorEnum.getError();
        this.message = message;
    }

    public ErrorResult(HttpServletRequest request, int status, String error, String message) {
        super(new Date(), status, request.getRequestURI());
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
