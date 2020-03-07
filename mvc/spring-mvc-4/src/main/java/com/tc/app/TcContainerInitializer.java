package com.tc.app;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 00:46
 * @Description:
 */
@HandlesTypes(TcApplicationInitializer.class)
public class TcContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("onStartup:   "+set);
    }
}
