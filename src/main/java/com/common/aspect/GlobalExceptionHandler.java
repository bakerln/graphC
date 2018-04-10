package com.common.aspect;

import com.common.util.json.JsonUtil;
import com.common.util.json.ResultMsg;
import com.common.util.web.WebUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by LiNan on 2018-04-09.
 * Description:系统全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletResponse httpServletResponse,Exception e){
        ResultMsg resultMsg = new ResultMsg("01","GlobalException",e.getClass());
        WebUtil.out(httpServletResponse,JsonUtil.createOperaStr(true,"GlobalException",resultMsg));
    }
}
