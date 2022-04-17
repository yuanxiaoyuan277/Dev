package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.service.PolicyService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private AlleviationMapper alleviationMapper;

    @Override
    public ResultVO add(Alleviation alleviation) {
        if (alleviation.getCreateTime() == null){
            alleviation.setCreateTime(new Date());
        }

        int i = alleviationMapper.insertSelective(alleviation);
        Alleviation result = alleviationMapper.selectByPrimaryKey(alleviation.getId());

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, result);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO del(Long id) {
        int i = alleviationMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;

        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(Alleviation alleviation) {
        int i = alleviationMapper.updateByPrimaryKeySelective(alleviation);
        Alleviation result = alleviationMapper.selectByPrimaryKey(alleviation.getId());

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, result);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize,Alleviation alleviation) {
        List<Alleviation> alleviations;
        ResultVO resultVO;

        try {
            if (alleviation.getType().equals("")){
                PageHelper.startPage(pageNum,pageSize);

                alleviations = alleviationMapper.selectByExample(null);
            }else {
                alleviations = alleviationMapper.selectByType("%"+alleviation.getType()+"%");
            }
            PageInfo<Alleviation> pageInfo = new PageInfo<>(alleviations);

            DataVO<Alleviation> dataVO = new DataVO<>(pageInfo.getTotal(),alleviations,pageNum,pageSize);

            resultVO = new ResultVO(200,"OK",true,dataVO);

        }catch (Exception e){
            resultVO = new ResultVO(-10000,"fail",false,null);
        }
        return resultVO;
    }

    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        ResultVO resultVO;
        if (lastClickTime == null){
            lastClickTime = new Date();
        }
        Integer i = alleviationMapper.click(id, lastClickTime);

        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }
}
