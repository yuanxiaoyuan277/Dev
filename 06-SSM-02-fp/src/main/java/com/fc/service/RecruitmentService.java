package com.fc.service;

import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface RecruitmentService {
    ResultVO add(VolunteerRecruitment volunteerRecruitment);

    ResultVO del(Long id);

    ResultVO update(VolunteerRecruitment volunteerRecruitment);

    ResultVO getList(Integer pageNum, Integer pageSize);

    ResultVO click(Long id, Date lastClickTime);
}
