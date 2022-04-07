package com.fc.controller;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poor")
public class poor {
    @Autowired
    private PoorService poorService;

    @RequestMapping("add")
    public ResultVO add(@RequestBody PoorWithBLOBs poorWithBLOBs){
        return poorService.add(poorWithBLOBs);
    }

    @RequestMapping("del")
    public ResultVO del(Long id){
        return poorService.del(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody PoorWithBLOBs poorWithBLOBs){
        return poorService.update(poorWithBLOBs);
    }

    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNum",required = false, defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize,
                            Poor poor){
        return poorService.getList(pageNum,pageSize,poor.getUsername());
    }
}
