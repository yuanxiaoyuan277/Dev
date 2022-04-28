package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface UserService {
    ModelAndView login(HttpSession session, TbUser user, Integer remember);

    ModelAndView logout();

    ModelAndView userCenter();

    ModelAndView update(MultipartFile img, String nick, String mood);

    ResultVO checkNick(String nickname);
}
