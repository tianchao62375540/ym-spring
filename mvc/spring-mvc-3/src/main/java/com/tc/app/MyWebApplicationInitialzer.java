package com.tc.app;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Auther: tianchao
 * @Date: 2020/2/21 22:58
 * @Description:
 */
public class MyWebApplicationInitialzer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("=============mvc-3======================");
    }
}
