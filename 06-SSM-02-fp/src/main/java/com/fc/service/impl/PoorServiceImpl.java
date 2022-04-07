package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    @Override
    public ResultVO add(PoorWithBLOBs poorWithBLOBs) {
        if (poorWithBLOBs.getCreateTime() == null){
            poorWithBLOBs.setCreateTime(new Date());
        }

        ResultVO resultVO;
        int i = poorMapper.insertSelective(poorWithBLOBs);
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO del(Long id) {
        int i = poorMapper.deleteByPrimaryKey(id);
        ResultVO resultVO ;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(PoorWithBLOBs poorWithBLOBs) {
        ResultVO resultVO;
        int i = poorMapper.updateByPrimaryKey(poorWithBLOBs);

        if (i > 0){
            PoorWithBLOBs result = poorMapper.selectByPrimaryKey(poorWithBLOBs.getId());

            resultVO = new ResultVO(200, "OK", true, result);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }

        return resultVO;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, String username) {
        List<Poor> poors;
        ResultVO resultVO;
        try {
            if (username == null){
                PageHelper.startPage(pageNum,pageSize);

                poors = poorMapper.selectByExample(null);
            }else {
                Poor poor = poorMapper.selectByUsername(username);
                poors = new ArrayList<>();
                poors.add(poor);
            }
            PageInfo<Poor> pageInfo = new PageInfo<>(poors);

            DataVO<Poor> dataVO = new DataVO<>(pageInfo.getTotal(),poors,pageNum,pageSize);

            resultVO = new ResultVO(200,"OK",true,dataVO);

        }catch (Exception e){
            resultVO = new ResultVO(-10000,"fail",false,null);
        }
        return resultVO;
    }
}
