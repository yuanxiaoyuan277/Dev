package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ModelAndView login(HttpSession session, TbUser user , @RequestParam(value = "remember",required = false)Integer remember){
        return userService.login(session,user,remember);
    }
    @RequestMapping("logout")
    public ModelAndView logout(){
        return userService.logout();
    }
    @RequestMapping("userCenter")
    public ModelAndView userCenter(){
        return userService.userCenter();
    }
    @PostMapping("update")
    public ModelAndView update(@RequestParam(value = "img", required = false)MultipartFile img,
                               @RequestParam(value = "nick", required = false)String nick,
                               @RequestParam(value = "mood", required = false)String mood){
        return userService.update(img,nick,mood);
    }
    @RequestMapping("checkNick")
    public ResultVO checkNick(String nickname){
        return userService.checkNick(nickname);
    }
}
