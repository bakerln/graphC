package com.common.aspect;

import com.common.util.web.WebUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by LiNan on 2018-04-09.
 * Description:系统全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("false");
//        return mv;
//    }
    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletResponse httpServletResponse){
        WebUtil.out(httpServletResponse,"error");
    }
}
