package com.example.demo.interceptor;

import com.example.demo.config.WrapResult;
import com.example.demo.entity.Result;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;


public class ResultHandler implements HandlerMethodReturnValueHandler {
    private HandlerMethodReturnValueHandler handler;

    public ResultHandler(HandlerMethodReturnValueHandler returnValueHandler) {
        this.handler = returnValueHandler;
    }
    //用自定义注解返回类型，必须为true
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return true;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        WrapResult annotation = returnType.getMethodAnnotation(WrapResult.class);
        //需要包装结果
        if (annotation != null){
          //  returnValue = Result.success(returnValue);
        }
        handler.handleReturnValue(returnValue, returnType, mavContainer, webRequest);

    }
}
