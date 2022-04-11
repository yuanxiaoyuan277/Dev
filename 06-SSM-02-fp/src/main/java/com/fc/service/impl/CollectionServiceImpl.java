package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.service.CollectionService;
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
public class CollectionServiceImpl extends PageHelper implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public ResultVO add(Collection collection) {
        if (collection.getCreateTime() == null){
            collection.setCreateTime(new Date());
        }
        int i = collectionMapper.insertSelective(collection);

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
        int i = collectionMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long userid) {
        List<Collection> collections;
        ResultVO resultVO;
        try {
            if (userid == null){
                PageHelper.startPage(pageNum,pageSize);

                collections = collectionMapper.selectByExample(null);
            }else {
                Collection collection = collectionMapper.selectByPrimaryKey(userid);
                collections = new ArrayList<>();
                collections.add(collection);
            }
            PageInfo<Collection> pageInfo = new PageInfo<>(collections);

            DataVO<Collection> dataVO = new DataVO<>(pageInfo.getTotal(),collections,pageNum,pageSize);

            resultVO = new ResultVO(200,"OK",true,dataVO);

        }catch (Exception e){
            resultVO = new ResultVO(-10000,"fail",false,null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(Collection collection) {
        ResultVO resultVO;
        int i = collectionMapper.updateByPrimaryKey(collection);

        if (i > 0){
            Collection result = collectionMapper.selectByPrimaryKey(collection.getId());

            resultVO = new ResultVO(200, "OK", true, result);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }

        return resultVO;
    }

}
