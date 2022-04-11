package com.fc.service;

import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface PoorService {
    ResultVO add(PoorWithBLOBs poorWithBLOBs);

    ResultVO del(Long id);

    ResultVO update(PoorWithBLOBs poorWithBLOBs);

    ResultVO getList(Integer pageNum, Integer pageSize, PoorWithBLOBs poor);

    ResultVO click(Long id, Date lastClickTime);

}
