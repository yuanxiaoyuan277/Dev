package com.fc.test;

import com.fc.dao.StudentMapper;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

public class GeneratorTest {
    @Test
    public  void test(){
        StudentMapper studentMapper = MyBatisUtil.getMapper(StudentMapper.class);

        Student student = studentMapper.selectByPrimaryKey(2);

        System.out.println(student);

        MyBatisUtil.commit();
    }
}
