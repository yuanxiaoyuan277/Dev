package com.fc.service;

import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVO;

public interface PoorService {
    ResultVO add(PoorWithBLOBs poorWithBLOBs);

    ResultVO del(Long id);

    ResultVO update(PoorWithBLOBs poorWithBLOBs);

    ResultVO getList(Integer pageNum, Integer pageSize, String username);
}