package com.returncode.apseboot.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 400 Bad Request 请求参数有误
 */
public class BadRequestException extends ErrorResultException {

    private static final HttpStatus ERROR = HttpStatus.BAD_REQUEST;

    /**
     * 400 Bad Request 请求参数有误
     */
    public BadRequestException() {
        super(ERROR.value(), ERROR.getReasonPhrase(), "参数错误");
    }

    /**
     * 400 Bad Request 请求参数有误
     *
     * @param message 错误消息
     */
    public BadRequestException(String message) {
        super(ERROR.value(), ERROR.getReasonPhrase(), message);
    }
}
