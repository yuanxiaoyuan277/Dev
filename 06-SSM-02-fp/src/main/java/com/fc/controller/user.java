package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class user {
    @Autowired
    private UserService userService;
    //用户删除
    @RequestMapping("del")
    public Map<String,Object> del(Integer id){
        Map<String, Object> map = new HashMap<>();
        int affectedRows = userService.del(id);
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
    public Map<String,Object> list(@RequestParam(value = "pageNo",required = false, defaultValue = "1")Integer pageNo
            ,@RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize
            ,@RequestParam(value = "id", required = false, defaultValue = "-1") Integer id){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> date = new HashMap<>();

        ArrayList<User> users = new ArrayList<>();
        User user;
        if (id !=-1){
            user = userService.findById(id);
            if (user != null) {
                users.add(user);
            }
        }else {
            users = userService.findAll(pageNo,pageSize);
        }
        PageInfo<User> info = new PageInfo<>(users);


        if (users.isEmpty()){
            map.put("message","KO！");
            map.put("code",404);
            map.put("success",false);
            map.put("date",date);
        }else {
            map.put("message","OK！");
            map.put("code",200);
            map.put("success",true);

            date.put("total",info.getTotal());
            date.put("list",users);
            date.put("pageNum",pageNo);
            date.put("pageSize",pageSize);
            map.put("date",date);
        }
        return map;
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
