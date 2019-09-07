package com.example.demo.interceptor;

import com.example.demo.config.Login;
import com.example.demo.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Login loginAnnotation = handlerMethod.getMethodAnnotation(Login.class);
            if (loginAnnotation == null) {
                Annotation[] annotations = handlerMethod.getBeanType().getAnnotations();
                for (Annotation annotation : annotations
                ) {
                    if (annotation.annotationType().equals(Login.class)) {
                        loginAnnotation = (Login) annotation;
                        break;
                    }
                }
            }
            if (loginAnnotation != null) {//此时loginAnnotation如果方法或类上有注解就不为空，没有为空
                String token = request.getHeader("token");
                if (StringUtils.isNotBlank(token)) {
                        request.setAttribute("token",token);
                    User user = new User();
                    user.setAge(17);
                    user.setName("jingjing");
                    request.setAttribute("user",user);
                }
                return true;
            }
            if (loginAnnotation == null){
                return false;//为空时，不能登录
            }
        }
        return false;
    }

}
