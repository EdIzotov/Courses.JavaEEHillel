package com.servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(asyncSupported = true, urlPatterns = "/asyncServlet")
public class AsyncServlet extends HttpServlet {
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync();
        executorService.execute(new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    asyncContext.getResponse().getWriter().println("Hello from thread");
                    asyncContext.complete();
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
