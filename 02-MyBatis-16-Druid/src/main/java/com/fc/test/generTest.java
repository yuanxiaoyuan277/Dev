package com.fc.test;

import com.fc.dao.StudentMapper;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

public class generTest {
    @Test
    public void tt(){
        StudentMapper mapper = MyBatisUtil.getMapper(StudentMapper.class);
        mapper.selectByPrimaryKey(2);

        MyBatisUtil.commit();
    }
}
