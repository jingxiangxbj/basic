package com.example.demo.interceptor;

import com.example.demo.config.Privilege;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@Component
public class PrivilegeInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Privilege methodAnnotation = handlerMethod.getMethodAnnotation(Privilege.class);
            if (methodAnnotation == null){
                return true;
            }
            if (methodAnnotation != null){
                String[] authorities = methodAnnotation.authorities();
                Set<String> set = new HashSet<>();
                if (authorities.length>0){
                    for (String authoritie:authorities
                         ) {
                        set.add(authoritie);
                    }
                    String role = request.getParameter("role");
                    if (StringUtils.isNotBlank(role)){
                        if(set.contains(role)){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

}
