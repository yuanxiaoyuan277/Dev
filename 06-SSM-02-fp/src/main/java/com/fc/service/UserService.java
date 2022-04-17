package com.fc.service;

import com.fc.entity.UserWithBLOBs;
import com.fc.vo.ResultVO;

public interface UserService{
    ResultVO del(Long id);

    ResultVO add(UserWithBLOBs user);

    ResultVO update(UserWithBLOBs user);

    ResultVO getList(Integer pageNum, Integer pageSize,String info ,String search);
}
