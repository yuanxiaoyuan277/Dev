package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("register")
    public Map<String,Object> register(User user){
        System.out.println(user);

        HashMap<String, Object> map = new HashMap<>();

        map.put("code",200);
        map.put("message","注册成功");
        map.put("success",true);
        map.put("data","用户名");

        return map;
    }
}
