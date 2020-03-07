package com.luban.app;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class SpringApplicationLuban {
    public static  void run() throws ServletException {
        Tomcat tomcat = new Tomcat();


        tomcat.setPort(8888);

        String sourcePath = SpringApplicationLuban.class.getResource("/").getPath();

        //告訴tomcat你的源碼在哪裏
        //Context ctx = tomcat.addWebapp("/",new File("src/main/webapp").getAbsolutePath());
        Context ctx = tomcat.addWebapp("/",new File("D:\\fight\\ym-spring\\mvc\\spring-mvc-6\\src\\main\\webapp").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",

                sourcePath, "/"));
        ctx.setResources(resources);
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
