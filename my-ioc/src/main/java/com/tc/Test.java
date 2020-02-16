package com.tc;


import com.tc.bean.Fox;
import ioc.anno.ApplicationContext;

/**
 * \
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context =  new ApplicationContext(AppConfig.class);

        System.out.println(context.getBean(Fox.class));


    }


}
