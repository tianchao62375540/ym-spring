package com.tc.all.proxy;

import com.tc.all.Cat;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2020/2/5 21:12
 * @Description:
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    public MyInstantiationAwareBeanPostProcessor(){
        System.out.println("MyInstantiationAwareBeanPostProcessor construct....");
    }
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("beanName:"+beanName+" 调用postProcessBeforeInstantiation()方法");
        if(beanClass == Cat.class){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(new MyMethodInterceptor());
            Object o = enhancer.create();
            System.out.println("返回动态代理");
            return o;
        }
        return null;
    }
}
