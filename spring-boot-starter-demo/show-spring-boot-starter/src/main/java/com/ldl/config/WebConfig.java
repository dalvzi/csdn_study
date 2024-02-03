package com.ldl.config;

import com.ldl.interceptor.ShowInfoInterceptor;
import com.ldl.prop.ShowProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ShowProperties showProperties() {
        return new ShowProperties();
    }

    @Bean
    public ShowInfoInterceptor showInfoInterceptor() {
        return new ShowInfoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(showInfoInterceptor())
                .addPathPatterns("/**");
//        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
