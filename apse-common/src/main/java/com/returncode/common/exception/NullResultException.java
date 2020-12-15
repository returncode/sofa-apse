package com.returncode.common.exception;


import com.returncode.common.enums.ErrorEnum;

/**
 * 空结果异常
 */
public class NullResultException extends ErrorResultException {

    private static final ErrorEnum ERROR = ErrorEnum.NULL_RESULT;

    public NullResultException() {
        super(ERROR.getState(), ERROR.getError(), ERROR.getMessage());
    }

    public NullResultException(String message) {
        super(ERROR.getState(), ERROR.getError(), message);
    }
}
