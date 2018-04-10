package com.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by LiNan on 2018-04-10.
 * Description:AOP切面
 */
@Aspect
@Component
public class ServiceExceptionAspect {
    //service异常捕获
    //dao层不允许有错误，controller层通过全局捕获
    @AfterThrowing(value = "execution(* com.*.service.*.*(..))", throwing = "e")
    public void loggingException(JoinPoint joinPoint, Exception e){
        // 拦截的实体类
        Object target = joinPoint.getTarget(); // 拦截的方法名称
        String methodName = joinPoint.getSignature().getName();
        System.out.println("实体类:" + target);
        System.out.println("异常类名：" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("方法名:" + methodName);
        // 得到被拦截方法参数，并打印
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("抛异常拦截： 被拦截到的方法参数：" + i + " -- " + args[i]);
        }
        System.out.println("异常类型: " + e.getClass());
        System.out.println("异常信息: " + e.getMessage());
    }
}
