package com.fc.service;

import com.fc.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService{
    int del(Integer id);

    int add(User user);

    int update(User user);

    User findById(Integer id);

    ArrayList<User> findAll(Integer pageNo, Integer pageSize);
}
