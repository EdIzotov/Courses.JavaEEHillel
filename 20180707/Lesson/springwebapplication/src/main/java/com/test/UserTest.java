package com.test;

import com.model.User;
import com.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {
//        UserService userService = new UserService();
//        List<User> allUsers = userService.getAllUsers();
//        System.out.println(allUsers);

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-application.xml");

        UserService userService = applicationContext.getBean("userService",
                UserService.class);
        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
    }
}
