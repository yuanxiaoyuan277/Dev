package com.fc.service;

import com.fc.vo.ResultVO;

public interface TypeService {
    ResultVO getList(Integer id);

    ResultVO delete(Integer id);

    ResultVO addOrUpdate(Integer typeId, String typeName, Integer id);
}
