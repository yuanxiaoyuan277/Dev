package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class SQLTest {
    @Test
    public void testSQL() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(2);
        student.setAge((byte) 12);
        List<Student> students = studentDao.findById(student);

        for (Student temp : students) {
            System.out.println(temp);
        }

        MyBatisUtil.commit();
    }
}
