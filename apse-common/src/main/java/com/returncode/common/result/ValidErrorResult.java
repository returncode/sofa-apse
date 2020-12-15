package com.returncode.common.result;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ValidErrorResult extends ErrorResult {

    private List<ObjectError> errors;

    public ValidErrorResult(HttpServletRequest request, HttpStatus httpStatus, List<ObjectError> errors, String message) {
        super(request, httpStatus, message);
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }
}
