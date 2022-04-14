package com.controllers;

import com.google.gson.Gson;
import com.model.Document;
import com.services.DocumentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DocumentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/spring-application.xml");
        DocumentService documentService = applicationContext.getBean("documentService", DocumentService.class);
        List<Document> allDocuments = documentService.getAllDocuments();
        String json = new Gson().toJson(allDocuments);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
