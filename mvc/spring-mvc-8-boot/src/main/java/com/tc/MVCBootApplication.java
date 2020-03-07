package com.tc;

import com.tc.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
import java.util.Base64;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 18:38
 * @Description:
 */
public class MVCBootApplication {

    public static void main(String[] args) {
        SpringApplication.run();
    }

    private static class SpringApplication{
        public static void run() {
            AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
            webApplicationContext.register(AppConfig.class);
            webApplicationContext.refresh();
            File file = new File(System.getProperty("java.io.tmpdir"));
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8899);
            Context ctx = tomcat.addContext("/", file.getAbsolutePath());
            DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
            Tomcat.addServlet(ctx, "mvc", dispatcherServlet).setLoadOnStartup(1);
            ctx.addServletMapping("/", "mvc");
            try {
                tomcat.start();
            } catch (LifecycleException e) {
                e.printStackTrace();
            }
            tomcat.getServer().await();


        }
    }

}
