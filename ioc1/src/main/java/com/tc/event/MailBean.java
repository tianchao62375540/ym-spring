package com.tc.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2020/2/20 23:36
 * @Description:
 */
@Component
public class MailBean implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public void send(){
        SpringMaillEvent springMaillEvent = new SpringMaillEvent(applicationContext);
        springMaillEvent.setContext("xxxxx");
        applicationContext.publishEvent(springMaillEvent);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }
}
