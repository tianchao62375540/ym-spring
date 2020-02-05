package com.tc.all.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: tianchao
 * @Date: 2020/2/5 21:16
 * @Description:
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("被代理了。。。。。。。。。。。。。。。。。");
        return methodProxy.invokeSuper(o,objects);
    }
}
