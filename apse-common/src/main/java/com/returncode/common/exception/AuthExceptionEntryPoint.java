package com.returncode.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.returncode.common.result.ErrorResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 资源服务器认证异常处理
 *
 * @Author: wanglei
 * @Date: 2020/5/19
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger = LogManager.getLogger();
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug(exception.getMessage(), exception);
        }
        int status = HttpStatus.UNAUTHORIZED.value();
        response.setStatus(status);
        response.setContentType("application/json;charset=UTF-8");
        ErrorResult result = new ErrorResult(request, status, "Unauthorized", "当前登录状态已失效，请重新登录");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }
}
