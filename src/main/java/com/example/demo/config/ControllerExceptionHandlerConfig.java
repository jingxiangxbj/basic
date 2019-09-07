package com.example.demo.config;

import com.example.demo.interceptor.ControllerExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@Configuration
//@ConditionalOnClass(RestControllerAdvice.class)
public class ControllerExceptionHandlerConfig {
//    @Bean
//    public ControllerExceptionHandler controllerExceptionHandler(){
//        return new ControllerExceptionHandler();
//    }
}
