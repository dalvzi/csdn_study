package com.ldl.aspectj;

import com.ldl.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {
    @Pointcut("@annotation(log)")
    public void webLog(Log log) {}

    @Before("webLog(log)")
    public void doBefore(JoinPoint joinPoint, Log log) {// 打印请求日志
        System.out.println("before" + log);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog(log)")
    public void doAfterReturning(Object ret, Log log) {// 打印响应结果日志
        System.out.println("doAfterReturning" + log);
    }

}
