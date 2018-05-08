package com.config.aspect;

import com.config.util.json.JsonUtil;
import com.config.interceptor.ResultMsg;
import com.config.util.web.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by LiNan on 2018-04-09.
 * Description:系统全局异常跳转
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger("sysLog");

    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletResponse httpServletResponse,Exception e){
//        logger.error("实体类: GlobalExcepton");
//        logger.error("异常类型: " + e.getClass());
//        logger.error("异常信息: " + e.getMessage());
        ResultMsg resultMsg = new ResultMsg("01","GlobalException","异常类型: " + e.getClass() + "  异常信息: " + e.getMessage());
        WebUtil.out(httpServletResponse,JsonUtil.createOperaStr(true,"GlobalException",resultMsg));
    }
}
