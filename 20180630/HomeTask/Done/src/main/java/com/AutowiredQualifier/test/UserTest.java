package com.AutowiredQualifier.test;

import com.AutowiredQualifier.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-application-autowired-qualifier.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.getUserList1());
        System.out.println(userService.getUserList2());
    }
}
