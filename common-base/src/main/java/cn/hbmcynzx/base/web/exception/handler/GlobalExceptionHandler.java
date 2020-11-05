package cn.hbmcynzx.base.web.exception.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Value("${spring.mvc.global.exception.errorUrl}")
    private String errorUrl;

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        log.error("请求异常：" + e.getMessage(), e);
        return "redirect:" + errorUrl;
    }
}