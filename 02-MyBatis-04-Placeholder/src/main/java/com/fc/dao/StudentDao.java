package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
    //查询所有小于指定年龄的人
    List<Student> findByAge(String age);
}
