package com.ldl.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(name = "mvc.interceptor.show", matchIfMissing = false)
@ComponentScan("com.ldl")
@Configuration
public class ShowInfoAutoConfig {
}
