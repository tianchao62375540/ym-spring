package com.tc.app;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 01:03
 * @Description:
 */
public class MySpringApplication {

    public static void run(){
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);
        //源码在哪里
        //Context context = tomcat.addWebapp("", "");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
