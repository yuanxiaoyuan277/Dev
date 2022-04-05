package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("carousel")
public class carousel {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("add")
    public Map<String,Object> add(Carousel carousel, @RequestParam(value = "is_carousel",required = false,defaultValue = "false") Boolean is_carousel){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> date = new HashMap<>();
        int i = carouselService.add(carousel,is_carousel);
        if (i == 0){
            map.put("message","添加失败！");
            map.put("code",404);
            map.put("success",false);
            map.put("date",date.put("errMsg","错误描述"));
        }else {
            map.put("message","添加成功！");
            map.put("code",200);
            map.put("success",true);
            map.put("date", "{}");
        }

        return map;
    }
}
