package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CollectionServiceImpl extends PageHelper implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public int add(Collection collection) {
        return collectionMapper.insert(collection);
    }

    @Override
    public int del(Long id) {
        return collectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Collection findById(long userid) {
        return collectionMapper.selectByPrimaryKey(userid);
    }

    @Override
    public ArrayList<Collection> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return (ArrayList<Collection>) collectionMapper.selectByExample(null);
    }
}
