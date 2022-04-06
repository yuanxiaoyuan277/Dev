package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVO;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    ResultVO del(Long id);

    ResultVO add(User user);

    ResultVO update(User user);

    ResultVO getList(Integer pageNum, Integer pageSize, Long id);
}
