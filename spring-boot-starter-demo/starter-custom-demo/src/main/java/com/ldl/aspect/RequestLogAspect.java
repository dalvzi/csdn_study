package com.ldl.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Method;
import java.util.HashMap;

@Slf4j
@Aspect
@Configuration(proxyBeanMethods = false)
@Profile({ServiceNameConstants.DEV_CODE})
public class RequestLogAspect {

    @Around(
            "execution(!static com.lnsoft.common.core.api.R *(..))" +
            "(@within(org.springfreamework.stererotype.Controller)" +
                    "@within(org.springfreamework.web.bind.annotation.RestController))"
    )
    public Object aroundApi(ProceedingJoinPoint point) throws Throwable{

        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        Object[] args = point.getArgs();
        // 请求参数处理
        final HashMap<String, Object> paraMap = new HashMap<>(16);
        for (int i = 0; i < args.length; i++) {
            // 读取方法参数 todo
            MethodParameter methodParam = null;
            //PathVariable 参数跳过
            PathVariable pathVariable = methodParam.getParameterAnnotation(PathVariable.class);
            if (pathVariable != null) {
                continue;
            }
            RequestBody requestBody = methodParam.getParameterAnnotation(RequestBody.class);
            String parameterName = methodParam.getParameterName();
            Object value = args[i];
            // 如果是body的json则是对象
            if (requestBody != null && value != null && !value.getClass().isArray()) {

            }
        }
        return null;
    }

}
interface ServiceNameConstants {

    String DEV_CODE = "dev";
    String TEST_CODE = "test";
    String PROD_CODE = "prod";

}
