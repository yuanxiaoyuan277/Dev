package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("collect")
public class collect {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("add")
    public Map<String,Object> add(Collection collection){
        Map<String, Object> map = new HashMap<>();
        int i = collectionService.add(collection);
        if (i == 0){
            map.put("message","收藏添加失败！");
            map.put("code",404);
            map.put("success",false);
            map.put("date",map.put("errMsg","错误描述"));
        }else {
            map.put("message","收藏添加成功！");
            map.put("code",200);
            map.put("success",true);
            map.put("date", null);
        }
        return map;
    }

    @RequestMapping("del")
    public Map<String,Object> del(Long id){
        Map<String, Object> map = new HashMap<>();
        int i = collectionService.del(id);
        if (i <= 0){
            map.put("message","收藏添加失败！");
            map.put("code",404);
            map.put("success",false);
            map.put("date",map.put("errMsg","错误描述"));
        }else {
            map.put("message","收藏添加成功！");
            map.put("code",200);
            map.put("success",true);
            map.put("date", null);
        }
        return map;
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(value = "pageNo",required = false, defaultValue = "1")Integer pageNo
            ,@RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize
            ,@RequestParam(value = "id", required = false, defaultValue = "-1") Integer userid){

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> date = new HashMap<>();

        ArrayList<Collection> collections = new ArrayList<>();

        Collection collection;

        if (userid !=-1){
            collection = collectionService.findById((long)userid);
            if (collection != null) {
                collections.add(collection);
            }
        }else {
            collections = collectionService.findAll(pageNo, pageSize);
        }

        PageInfo<Collection> info = new PageInfo<>(collections);

        if (collections.isEmpty()){
            map.put("message","KO！");
            map.put("code",404);
            map.put("success",false);
            map.put("date",date);
        }else {
            map.put("message","OK！");
            map.put("code",200);
            map.put("success",true);

            date.put("total",info.getTotal());
            date.put("list",collections);
            date.put("pageNum",pageNo);
            date.put("pageSize",pageSize);
            map.put("date",date);
        }
        return map;
    }

}
