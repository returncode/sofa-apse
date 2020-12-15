package com.returncode.common.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.returncode.common.result.ErrorResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 统一认证异常处理
 *
 * @Author: wanglei
 * @Date: 2020/5/18
 */
public class ErrorOAuthExceptionSerializer extends StdSerializer<ErrorOAuthException> {

    private static final Logger logger = LogManager.getLogger();

    public ErrorOAuthExceptionSerializer() {
        super(ErrorOAuthException.class);
    }

    @Override
    public void serialize(ErrorOAuthException exception, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (logger.isDebugEnabled()) {
            logger.debug(exception.getOAuth2ErrorCode() + " " + exception.getMessage(), exception);
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ErrorResult result = new ErrorResult(request, exception.getHttpErrorCode(), exception.getOAuth2ErrorCode(), exception.getMessage());
        jsonGenerator.writeObject(result);
    }
}
