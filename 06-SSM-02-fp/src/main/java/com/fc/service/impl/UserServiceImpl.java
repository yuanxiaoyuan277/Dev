package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.entity.UserWithBLOBs;
import com.fc.service.UserService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends PageHelper implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVO del(Long id) {
        int i = userMapper.deleteByPrimaryKey(id);
        ResultVO resultVO ;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(UserWithBLOBs user) {
        if (user.getCreateTime() == null){
            user.setCreateTime(new Date());
        }

        ResultVO resultVO;
        int i = userMapper.insertSelective(user);
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(UserWithBLOBs user) {
        ResultVO resultVO;
        int i = userMapper.updateByPrimaryKey(user);

        if (i > 0){
            User result = userMapper.selectByPrimaryKey(user.getId());

            resultVO = new ResultVO(200, "OK", true, result);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }

        return resultVO;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize,String info ,String search) {
        List<User> users = null;
        ResultVO resultVO;
        try {
            if (search.equals("")){
                PageHelper.startPage(pageNum,pageSize);

                users = userMapper.selectByExample(null);
            }else {
                if(info.equals("zhanghao")){
                    users = userMapper.selectByUserName("%"+search+"%");
                }
                if (info.equals("xingming")){
                    users = userMapper.selectByName("%"+search+"%");
                }

            }
            assert users != null;
            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVO<User> dataVO = new DataVO<>(pageInfo.getTotal(),users,pageNum,pageSize);

            resultVO = new ResultVO(200,"OK",true,dataVO);

        }catch (Exception e){
            resultVO = new ResultVO(-10000,"fail",false,null);
        }
        return resultVO;
    }

}
