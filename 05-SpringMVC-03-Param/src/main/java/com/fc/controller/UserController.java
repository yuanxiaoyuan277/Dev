package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("register")
    public String regisrter(String name,Integer age,String gender,String birthday,String info){
        System.out.println(name + " " + age + "" + gender + "" + birthday + " " + info);

        //页面跳转路径
        return "/success.jsp";
    }
}
