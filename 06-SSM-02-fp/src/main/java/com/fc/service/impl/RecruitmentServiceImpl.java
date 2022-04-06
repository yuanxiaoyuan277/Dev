package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.RecruitmentService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;

    @Override
    public ResultVO add(VolunteerRecruitment volunteerRecruitment) {
        int i = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO del(Long id) {
        int i = volunteerRecruitmentMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(VolunteerRecruitment volunteerRecruitment) {
        int i = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);
        VolunteerRecruitment result = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, result);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize) {
        List<VolunteerRecruitment> volunteerRecruitments;
        ResultVO resultVO;

        try {

                PageHelper.startPage(pageNum,pageSize);

            volunteerRecruitments = volunteerRecruitmentMapper.selectByExample(null);

            PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(volunteerRecruitments);

            DataVO<VolunteerRecruitment> dataVO = new DataVO<>(pageInfo.getTotal(),volunteerRecruitments,pageNum,pageSize);

            resultVO = new ResultVO(200,"OK",true,dataVO);

        }catch (Exception e){
            resultVO = new ResultVO(-10000,"fail",false,null);
        }
        return resultVO;
    }
}
