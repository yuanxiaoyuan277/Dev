package com.fc.service;

import com.fc.entity.Carousel;
import com.fc.vo.ResultVO;

public interface CarouselService {
    ResultVO add(Carousel carousel, Boolean is_carousel);

    ResultVO del(Integer id);

    ResultVO update(Carousel carousel);

    ResultVO getList(Integer pageNum, Integer pageSize, Integer id);

    ResultVO changeStatus(Integer id);
}
