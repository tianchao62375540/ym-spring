package com.tc.app;

import com.tc.app.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Auther: tianchao
 * @Date: 2020/2/21 23:18
 * @Description:
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(AppConfig.class);
        webContext.refresh();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("servlet", dispatcherServlet);
        dynamic.addMapping("*.do");
        dynamic.setLoadOnStartup(1);
    }
}
