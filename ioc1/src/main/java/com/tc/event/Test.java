package com.tc.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: tianchao
 * @Date: 2020/2/20 22:57
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EventAppConfig.class);
        //((AnnotationConfigApplicationContext) context).start();
        MailBean bean = context.getBean(MailBean.class);
        bean.send();
        System.out.println("main end....");
    }
}
