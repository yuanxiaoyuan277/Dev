package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.dao.SubjectDao;
import com.fc.entity.Student;
import com.fc.entity.Subject;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class MoreTableTest {
    @Test
    public void testSubject() {
        SubjectDao subjectDao = MyBatisUtil.getMapper(SubjectDao.class);

        List<Subject> subjects = subjectDao.findAllWithStudent();

        for (Subject subject : subjects) {
            System.out.println(subject);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testStudent() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findAllWithSubject();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }
}
