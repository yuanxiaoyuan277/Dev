package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public int add(Carousel carousel, Boolean is_carousel) {
        return carouselMapper.insertSelective(carousel);
    }

    @Override
    public int del(Integer id) {
       return carouselMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Carousel carousel) {
        return carouselMapper.updateByPrimaryKey(carousel);
    }
}
