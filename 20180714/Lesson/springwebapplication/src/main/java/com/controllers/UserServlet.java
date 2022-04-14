package com.controllers;

import com.google.gson.Gson;
import com.model.User;
import com.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/spring-application.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        List<User> allUsers = userService.getAllUsers();
        String json = new Gson().toJson(allUsers);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
