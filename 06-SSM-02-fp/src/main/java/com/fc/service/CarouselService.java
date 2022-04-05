package com.fc.service;

import com.fc.entity.Carousel;

public interface CarouselService {
    int add(Carousel carousel, Boolean is_carousel);

    int del(Integer id);

    int update(Carousel carousel);
}
