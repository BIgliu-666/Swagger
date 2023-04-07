package com.liujin.controller;

import com.liujin.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PutMapping
    //@ApiOperation方法的注解
    @ApiOperation("添加user")
    //@ApiParam是参数的注解
    public String addUser(@ApiParam("用户") User user) {
        return "测试";
    }

    @GetMapping
    public User selectUser() {
        return new User();
    }
}

