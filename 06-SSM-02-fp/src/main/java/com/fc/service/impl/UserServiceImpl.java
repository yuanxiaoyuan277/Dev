package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl extends PageHelper implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int del(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArrayList<User> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return (ArrayList<User>) userMapper.selectByExample(null);
    }

}
