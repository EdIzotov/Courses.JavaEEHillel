package com.controllers;

import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServlet extends HttpServlet {
    private List<User> users =
            new ArrayList(Arrays.asList(new User("usr1"),
                    new User("usr2")));


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("hello from servlet");
        //String username = req.getParameter("username");

        req.setAttribute("userList", users);
        req.getRequestDispatcher("/WEB-INF/pages/user.jsp").
                forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        User user = new User(userName);
        users.add(user);

        req.setAttribute("userList", users);
        req.getRequestDispatcher("/WEB-INF/pages/user.jsp").
                forward(req, resp);
    }
}
