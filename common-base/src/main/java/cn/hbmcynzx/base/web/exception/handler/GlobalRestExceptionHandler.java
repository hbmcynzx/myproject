package cn.hbmcynzx.base.web.exception.handler;

import cn.hbmcynzx.base.utils.ResultMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalRestExceptionHandler {

    @Value("${spring.mvc.global.exception.rest.message}")
    private String errorMsg;

    @ExceptionHandler(Exception.class)
    public ResultMsg exceptionHandler(Exception e) {
        log.error("请求异常：" + e.getMessage(), e);
        return ResultMsg.error(errorMsg);
    }
}
