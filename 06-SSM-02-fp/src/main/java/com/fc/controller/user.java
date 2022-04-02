package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class user {
    @Autowired
    private UserService userService;
    //用户删除
    @RequestMapping("del")
    public Map<String,Object> del(String id){
        Map<String, Object> map = new HashMap<>();
        long ids = Long.parseLong(id);
        int affectedRows = userService.del(ids);
        if (affectedRows == 0){
            map.put("message","用户删除失败！");
            map.put("code",404);
            map.put("success",false);
            map.put("date",map.put("errMsg","错误描述"));
        }else {
            map.put("message","用户删除成功！");
            map.put("code",200);
            map.put("success",true);
            map.put("date",null);
        }
        return map;
    }
    //用户修改
    @RequestMapping("update")
    public Map<String, Object> update(User user){
        Map<String, Object> map = new HashMap<>();
        int i = 0;
        try{
            i = userService.update(user);
        }finally {
            if (i == 0){
                map.put("message","用户修改失败！");
                map.put("code",404);
                map.put("success",false);
                map.put("date",map.put("errMsg","错误描述"));
            }else {
                map.put("message","用户修改成功！");
                map.put("code",200);
                map.put("success",true);
                map.put("date", null);
            }
            return map;
        }
    }
    //用户获取
    @RequestMapping("list")
    public List<User> list(Integer id){
        // 一行代码搞定，需要声明当前页和每页显示多少条数据
        PageHelper.startPage(100000, 2);

//        List<User> user = UserDao.findAll();
        return null;
    }
    //用户添加
    @RequestMapping("add")
    public Map<String, Object> add (User user){
        Map<String, Object> map = new HashMap<>();
       int affectedRows = 0;
        try{
            affectedRows = userService.add(user);
        }finally {
            if (affectedRows == 0){
                map.put("message","用户添加失败！");
                map.put("code",404);
                map.put("success",false);
                map.put("date",map.put("errMsg","错误描述"));
            }else {
                map.put("message","用户添加成功！");
                map.put("code",200);
                map.put("success",true);
                map.put("date", null);
            }
            return map;
        }

    }
}
