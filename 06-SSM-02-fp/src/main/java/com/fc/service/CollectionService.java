package com.fc.service;

import com.fc.entity.Collection;

import java.util.ArrayList;

public interface CollectionService {
    int add(Collection collection);

    int del(Long id);

    Collection findById(long userid);

    ArrayList<Collection> findAll(Integer pageNo, Integer pageSize);
}
