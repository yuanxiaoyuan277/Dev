package com.fc.controller;

import com.fc.entity.UserWithBLOBs;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class user {
    @Autowired
    private UserService userService;
    //用户删除
    @RequestMapping("delete")
    public ResultVO del(Long id){
        return userService.del(id);
    }
    //用户修改
    @RequestMapping("update")
    public ResultVO update(@RequestBody UserWithBLOBs user){
            return userService.update(user);
    }
    //用户获取
    @RequestMapping("getList")
    public ResultVO list(@RequestParam(value = "pageNum",required = false, defaultValue = "1")Integer pageNum
                        , @RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize
                        , String info ,String search){
        return userService.getList(pageNum,pageSize,info,search);
    }
    //用户添加
    @RequestMapping("add")
    public ResultVO add (@RequestBody UserWithBLOBs user){
            return userService.add(user);
    }
}
