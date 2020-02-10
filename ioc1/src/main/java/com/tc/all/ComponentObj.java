package com.tc.all;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Auther: tianchao
 * @Date: 2020/2/5 16:36
 * @Description:
 */
@Component
public class ComponentObj implements BeanFactoryAware, InitializingBean, ApplicationContextAware {
    BeanFactory beanFactory;
    ApplicationContext applicationContext;
    public ComponentObj(){
        System.out.println("ComponentObj constructor....");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("@PostConstruct");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
