package com.fc.text;

import com.fc.config.ApplicationContextConfig;
import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testFindAll(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDaoImpl.class);

        List<User> users = userDao.findAll();

        System.out.println(users);
    }
    @Test
    public void testFindAllByID(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        User user = userDao.findById(1);

        System.out.println(user);
    }
}
