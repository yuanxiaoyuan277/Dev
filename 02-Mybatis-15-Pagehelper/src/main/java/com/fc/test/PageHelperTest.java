package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import java.util.List;

public class PageHelperTest {
    @Test
    public void test() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        PageHelper.startPage(1,2);

        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }
    @Test
    public void testPageInfo(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        PageHelper.startPage(1000,2);

        List<Student> students = studentDao.findAll();

        PageInfo<Student> pageInfo = new PageInfo<>(students);

        System.out.println(pageInfo);

    }

}
