package com.fc.controller;

import com.fc.service.TypeService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("type")
public class typeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("list")
    public ResultVO list(Integer id){
        return typeService.getList(id);
    }

    @RequestMapping("delete")
    public ResultVO delete(Integer id){
        return typeService.delete(id);
    }

    @RequestMapping("addOrUpdate")
    public ResultVO addOrUpdate(Integer typeId, String typeName,
                                @RequestParam(value = "id" ,required = false)Integer id){
        return typeService.addOrUpdate(typeId,typeName,id);
    }
}
