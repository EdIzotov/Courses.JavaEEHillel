package com.test;

import com.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserSystemTest {
    public static void main(String[] args) {
//        UserService userService = new UserService();
//        System.out.println(userService.getUserList());

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-application.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);

        //scope бинов -> существуешь ли ты в одном экземпляре,
        // либо в scope prototype(множественное число)
        System.out.println(userService == userService2);


        System.out.println(userService.getUserList());

    }
}
