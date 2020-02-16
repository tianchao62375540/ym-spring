package com.tc;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 19:47
 * @Description:
 */
@WebServlet(value="/annoHello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloServlet doGet()");
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>Hello World</h1>");
    }
}
