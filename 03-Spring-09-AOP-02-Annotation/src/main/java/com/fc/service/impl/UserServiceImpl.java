package com.fc.service.impl;

import com.fc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("添加了一个新用户");
    }

    @Override
    public void update() {
        int num = 1 / 0;
        System.out.println("修改了用户信息");

    }
}
