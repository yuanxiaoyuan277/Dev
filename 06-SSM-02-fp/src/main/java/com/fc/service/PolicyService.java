package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface PolicyService {
    ResultVO add(Alleviation alleviation);

    ResultVO del(Long id);

    ResultVO update(Alleviation alleviation);

    ResultVO getList(Integer pageNum, Integer pageSize,Alleviation alleviation);

    ResultVO click(Long id, Date lastClickTime);
}
