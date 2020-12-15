package com.returncode.apseboot.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.returncode.apseboot.common.result.ErrorResult;
import com.returncode.apseboot.common.result.ValidErrorResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.io.IOException;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionResolver {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    ObjectMapper objectMapper;

    /**
     * 结果错误异常处理
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @ExceptionHandler(value = ErrorResultException.class)
    public void errorResultHandler(HttpServletRequest request, HttpServletResponse response, ErrorResultException exception) throws IOException {
        if (logger.isDebugEnabled()) {
            logger.debug(exception.getMessage(), exception);
        }
        response.setStatus(exception.getStatus());
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, exception.getStatus(), exception.getError(), exception.getMessage());
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * 资源服务访问权限不足异常
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @ExceptionHandler({AccessDeniedException.class})
    public void errorResultHandler(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException {
        int status = HttpStatus.UNAUTHORIZED.value();
        response.setStatus(status);
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, status, "Unauthorized", "访问权限不足");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * 验证错误异常处理
     *
     * @param request
     * @param response
     * @param exception
     */
    @ExceptionHandler(value = BindException.class)
    public void errorValidationHandler(HttpServletRequest request, HttpServletResponse response, BindException exception) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json;charset=UTF-8");
        ValidErrorResult result = new ValidErrorResult(request, HttpStatus.BAD_REQUEST, exception.getAllErrors(), "参数错误");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * 验证错误异常处理
     *
     * @param request
     * @param response
     * @param exception
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public void errorValidationHandler(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException exception) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json;charset=UTF-8");
        ValidErrorResult result = new ValidErrorResult(request, HttpStatus.BAD_REQUEST, exception.getBindingResult().getAllErrors(), "参数错误");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * GET请求参数未传异常监听<br/>
     * 对 org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver 补偿
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @ExceptionHandler(value = IllegalStateException.class)
    public void errorValidationHandler(HttpServletRequest request, HttpServletResponse response, IllegalStateException exception) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), "参数错误");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * 对 @Valid 中配置的验证类型处理错误异常监听<br/>
     * 对 org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver 补偿
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @ExceptionHandler(value = UnexpectedTypeException.class)
    public void errorValidationHandler(HttpServletRequest request, HttpServletResponse response, UnexpectedTypeException exception) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), "参数错误");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * 对 @Valid 中配置的验证类型为List时处理错误异常监听<br/>
     * 对 org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver 补偿
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public void errorValidationHandler(HttpServletRequest request, HttpServletResponse response, ConstraintViolationException exception) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), "参数错误");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * 请求参数中带 @RequestParam 的参数未传异常监听<br/>
     * 对 org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver 覆盖
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public void errorValidationHandler(HttpServletRequest request, HttpServletResponse response, MissingServletRequestParameterException exception) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), "参数错误");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * REST请求异常处理
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @ExceptionHandler(value = HttpStatusCodeException.class)
    public void handleException(HttpServletRequest request, HttpServletResponse response, HttpStatusCodeException exception) throws IOException {
        if (logger.isWarnEnabled()) {
            logger.warn(exception.getMessage(), exception);
        }
        HttpStatus status = exception.getStatusCode();
        response.setStatus(status.value());
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, status.value(), status.name(), status.getReasonPhrase());
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

    /**
     * 服务器未知异常
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @ExceptionHandler(value = Exception.class)
    public void handleException(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException {
        if (logger.isWarnEnabled()) {
            logger.warn(exception.getMessage(), exception);
        }
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), "内部服务器错误");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

}
