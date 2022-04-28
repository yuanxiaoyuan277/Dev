package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.util.FileUploadUtil;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public ModelAndView login(HttpSession session, TbUser user, Integer remember) {
        if (remember != 1){

        }

        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        if (tbUsers == null){
            return new ModelAndView("redirect:/login.jsp");
        }else {
            Cookie cookie = new Cookie("cookie","JSESSIONID");
            return new ModelAndView("redirect:/index.jsp");
        }

    }

    @Override
    public ModelAndView logout() {
        return new ModelAndView("redirect:/login.jsp");
    }

    @Override
    public ModelAndView userCenter() {
        return new ModelAndView("redirect:/user/info.jsp");
    }

    @Override
    public ModelAndView update(MultipartFile img, String nick, String mood) {
        if (!img.isEmpty()){
            FileUploadUtil.fileUpload(img);
        }else {

        }
        return new ModelAndView("user/userCenter");
    }

    @Override
    public ResultVO checkNick(String nickname) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andNickEqualTo(nickname);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        ResultVO vo = new ResultVO();
        if (tbUsers == null) {
            vo.setCode(0);
        }else {
            vo.setCode(1);
        }
        return vo;
    }
}
