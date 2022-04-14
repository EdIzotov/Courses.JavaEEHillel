package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/usernames")
public class UserNamesController extends HttpServlet {
    private List<String> usernames = new ArrayList();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/usernames.jsp").forward(req, resp);
    }
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userNameComponent");
        usernames.add(userName);
        req.setAttribute("names", usernames);
        req.getRequestDispatcher("/WEB-INF/pages/usernames.jsp").forward(req, resp);
    }
}
