package com.nowcode.blive.service.handler;

import com.nowcode.blive.domain.JsonResponse;
import com.nowcode.blive.domain.exception.ConditionException;
import org.apache.tomcat.util.security.ConcurrentMessageDigest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title: CommonGlobalExceptionHandler
 * @Package: com.nowcode.blive.service.handler
 * @description:
 * @author: Stackingrule
 * @created: 2022/02/25 19:42
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonGlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResponse<String> commonExceptionHandler(HttpServletRequest request, Exception e) {
        String errorMsg = e.getMessage();
        if (e instanceof ConditionException) {
            String errorCode = ((ConditionException)e).getCode();
            return new JsonResponse<>(errorCode, errorMsg);
        } else {
            return new JsonResponse<>("500", errorMsg);
        }
    }
}
