package com.fc.service;

import com.fc.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int del(long id);

    int add(User user);

    int update(User user);
}
