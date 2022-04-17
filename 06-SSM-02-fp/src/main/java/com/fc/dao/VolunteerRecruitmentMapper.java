package com.fc.dao;

import com.fc.entity.VolunteerRecruitment;
import com.fc.entity.VolunteerRecruitmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface VolunteerRecruitmentMapper {
    long countByExample(VolunteerRecruitmentExample example);

    int deleteByExample(VolunteerRecruitmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VolunteerRecruitment record);

    int insertSelective(VolunteerRecruitment record);

    List<VolunteerRecruitment> selectByExampleWithBLOBs(VolunteerRecruitmentExample example);

    List<VolunteerRecruitment> selectByExample(VolunteerRecruitmentExample example);

    VolunteerRecruitment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VolunteerRecruitment record, @Param("example") VolunteerRecruitmentExample example);

    int updateByExampleWithBLOBs(@Param("record") VolunteerRecruitment record, @Param("example") VolunteerRecruitmentExample example);

    int updateByExample(@Param("record") VolunteerRecruitment record, @Param("example") VolunteerRecruitmentExample example);

    int updateByPrimaryKeySelective(VolunteerRecruitment record);

    int updateByPrimaryKeyWithBLOBs(VolunteerRecruitment record);

    int updateByPrimaryKey(VolunteerRecruitment record);

    Integer click(@Param(("id")) Long id,@Param("lastClickTime") Date lastClickTime);

//    暂未写出SQL语句
    List<VolunteerRecruitment> selectByPosition(@Param("position") String position);

    List<VolunteerRecruitment> selectBySalary(@Param("salary")String salary);

    List<VolunteerRecruitment> selectByLead(@Param("lead")String lead);
}