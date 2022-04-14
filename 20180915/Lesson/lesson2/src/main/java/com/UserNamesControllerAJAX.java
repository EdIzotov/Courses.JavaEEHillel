package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/usernames-ajax")
public class UserNamesControllerAJAX extends HttpServlet {
    private List<User> users = new ArrayList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/ajax.jsp").forward(req, resp);
    }
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServletInputStream servletInputStream = req.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(servletInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             PrintWriter printWriter = resp.getWriter();
             ) {
            String json = bufferedReader.readLine();
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(json, User.class);
            users.add(user);
            objectMapper.writeValue(printWriter, users);
        }
    }
}
