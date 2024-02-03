package com.ldl.aspectTest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {

    @Pointcut("execution(* com.ldl.controller.*.*(..))" +
            " (@within(org.springfreamework.stererotype.Controller)" +
            " @within(org.springfreamework.web.bind.annotation.RestController))")
    public void pointcut() {}

    @Around("pointcut()")
    public  Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around前");
        Object proceed = point.proceed();
        System.out.println("around后");
        return proceed;
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint joinPoint) throws Throwable {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(JoinPoint joinPoint) throws Throwable {
        System.out.println("afterReturning");
    }



}
