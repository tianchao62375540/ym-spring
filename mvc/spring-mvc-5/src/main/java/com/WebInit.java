package com;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 10:46
 * @Description:
 */
public interface WebInit {
    void onStartup(ServletContext servletContext) throws ServletException;
}
