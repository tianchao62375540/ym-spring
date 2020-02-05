package com.tc.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 13:38
 * @Description:
 */
@Component
public class MyFactoryBean implements FactoryBean<FactoryBeanObject> {

    @Override
    public FactoryBeanObject getObject() throws Exception {
        return new FactoryBeanObject();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanObject.class;
    }
}
