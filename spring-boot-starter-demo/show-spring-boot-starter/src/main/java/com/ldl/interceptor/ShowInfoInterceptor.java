package com.ldl.interceptor;


import com.ldl.prop.ShowProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowInfoInterceptor implements HandlerInterceptor {

    @Autowired
    private ShowProperties showProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (showProperties.isShow()) {
            //拦截执行逻辑
            if (StringUtils.hasText(showProperties.getInfo())) {
                System.out.println(showProperties.getInfo());
            } else {
                System.out.println("Hello....");
            }
        }
            return true;
//            return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
