package cn.hbmcynzx.base.web.exception.handler;

import cn.hbmcynzx.base.exception.BusinessException;
import cn.hbmcynzx.base.utils.ResultMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局ajax请求异常处理
 * @author hbmcynzx
 */
@RestControllerAdvice
@Slf4j
public class GlobalRestExceptionHandler {

    @Value("${spring.mvc.global.exception.rest.message}")
    private String errorMsg;

    /**
     * controller抛出exception异常时，返回json数据
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultMsg exceptionHandler(HttpServletRequest request, Exception e) {
        ResultMsg msg = null;
        log.error("请求异常：请求路径：{}，异常信息：{}", request.getRequestURI(), e.getMessage());
        log.error("请求异常：", e);
        if(e instanceof BusinessException) {
            //业务异常，返回业务异常信息
            msg = ResultMsg.error(e.getMessage());
        } else if(e instanceof MissingServletRequestParameterException) {
            //http request参数缺失异常
            msg = handleMissingServletRequestParameterException((MissingServletRequestParameterException) e);
        } else {
            msg = ResultMsg.error(errorMsg);
        }
        return msg;
    }

    /**
     * 处理参数缺失异常
     * @return
     */
    private ResultMsg handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResultMsg.error(String.format("缺失参数[%s:%s]", e.getParameterType(), e.getParameterName()));
    }


}
