package com.fc.controller;

import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PolicyService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("policy")
public class policy {
    @Autowired
    private PolicyService policyService;

    @RequestMapping("add")
    public ResultVO add(@RequestBody PoorWithBLOBs poorWithBLOBs){
        return policyService.add(poorWithBLOBs);
    }

    @RequestMapping("del")
    public ResultVO del(Long id){
        return policyService.del(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody PoorWithBLOBs poorWithBLOBs){
        return policyService.update(poorWithBLOBs);
    }

    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNum",required = false, defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize){
        return policyService.getList(pageNum,pageSize);
    }
}
