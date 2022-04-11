package com.fc.service;

import com.fc.entity.Collection;
import com.fc.vo.ResultVO;

public interface CollectionService {
    ResultVO add(Collection collection);

    ResultVO del(Long id);

    ResultVO getList(Integer pageNum, Integer pageSize, Long userid);

    ResultVO update(Collection collection);
}
