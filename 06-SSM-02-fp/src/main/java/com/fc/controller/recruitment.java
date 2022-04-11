package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.RecruitmentService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("volunteer")
public class recruitment {
    @Autowired
    private RecruitmentService recruitmentService;

    @RequestMapping("add")
    public ResultVO add(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.add(volunteerRecruitment);
    }

    @RequestMapping("delete")
    public ResultVO del(Long id){
        return recruitmentService.del(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return recruitmentService.update(volunteerRecruitment);
    }
    @RequestMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",required = false, defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize){
        return recruitmentService.getList(pageNum,pageSize);
    }
    @RequestMapping("click")
    public ResultVO click(Long id, Date lastClickTime){
        return recruitmentService.click(id,lastClickTime);
    }
}
