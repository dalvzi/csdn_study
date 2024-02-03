package com.ldl.config;

import com.ldl.aspectj.LogAspect;
import com.ldl.prop.LogProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LogProperties.class)
@ConditionalOnProperty(name = "mvc.log.enabled", matchIfMissing = true)
@ComponentScan("com.ldl")
public class LogAspectEnableAutoConfiguration {
        @Bean
        public LogProperties LogProperties(){
            return new LogProperties();
        }
        @Bean
        public LogAspect LogAspect() {
            return new LogAspect();
        }
}
