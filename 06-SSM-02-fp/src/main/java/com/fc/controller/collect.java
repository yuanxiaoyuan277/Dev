package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("collect")
public class collect {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("add")
    public ResultVO add(@RequestBody Collection collection){
        return collectionService.add(collection);
    }

    @RequestMapping("del")
    public ResultVO del(Long id){
        return collectionService.del(id);
    }

    @RequestMapping("list")
    public ResultVO list(@RequestParam(value = "pageNo",required = false, defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize
            ,Long userid){
        return collectionService.getList(pageNum,pageSize,userid);
    }

}
