package com.example.demo.controller;

import com.example.demo.config.BaseException;
import com.example.demo.config.Login;
import com.example.demo.config.Privilege;
import com.example.demo.config.WrapResult;
import com.example.demo.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @WrapResult
    @Login
    @Privilege(authorities = "admin", role = "admin")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("role") String role) {
        User user = new User();
        if (StringUtils.isNotBlank(name) && age != null) {
           throw new BaseException(300,"参数错误");
        }
        return user;
    }
}
