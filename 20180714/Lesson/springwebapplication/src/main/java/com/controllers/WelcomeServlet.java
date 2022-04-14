package com.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // response.getWriter().println("HELLO!");
        String username = request.getParameter("username");
        request.setAttribute("name", username);
        String param2 = request.getParameter("param2");
        request.setAttribute("param2", param2);

        request.getRequestDispatcher("/WEB-INF/pages/user.jsp").forward(request, response);
    }
}
