package com;

import web.SpringServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 10:43
 * @Description:
 */
@HandlesTypes(WebInit.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("=================");
        ServletRegistration.Dynamic registration=servletContext.addServlet("xx",new SpringServlet());
        registration.addMapping("/");
        Iterator<Class<?>> iterator = set.iterator();
        while (iterator.hasNext()){
            Class<?> next = iterator.next();
            Object o = null;
            try {
                o = next.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            WebInit webinit = (WebInit) o;
            webinit.onStartup(servletContext);
        }
        

    }
}
