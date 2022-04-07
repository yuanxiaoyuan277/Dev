package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.PolicyService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("policy")
public class policy {
    @Autowired
    private PolicyService policyService;

    @RequestMapping("add")
    public ResultVO add(@RequestBody Alleviation alleviation){
        return policyService.add(alleviation);
    }

    @RequestMapping("del")
    public ResultVO del(Long id){
        return policyService.del(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody Alleviation alleviation){
        return policyService.update(alleviation);
    }

    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNum",required = false, defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize){
        return policyService.getList(pageNum,pageSize);
    }
    @RequestMapping("click")
    public ResultVO click(@RequestBody Alleviation alleviation){
        return policyService.click(alleviation.getId(),alleviation.getLastClickTime());
    }
}
