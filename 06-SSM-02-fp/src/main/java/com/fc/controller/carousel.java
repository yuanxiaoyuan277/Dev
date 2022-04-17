package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class carousel {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("add")
    public ResultVO add(@RequestBody Carousel carousel, @RequestParam(value = "is_carousel",required = false,defaultValue = "false") Boolean is_carousel){
        return carouselService.add(carousel,is_carousel);
    }

    @RequestMapping("delete")
    public ResultVO del(Integer id){
        return carouselService.del(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody Carousel carousel){
        return carouselService.update(carousel);
    }

    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNum",required = false, defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize,
                            Integer id){
        return carouselService.getList(pageNum,pageSize,id);
    }

    @RequestMapping("state")
    public ResultVO changeState(Integer id){
        return carouselService.changeStatus(id);
    }
}
