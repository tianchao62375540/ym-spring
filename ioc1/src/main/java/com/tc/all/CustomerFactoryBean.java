package com.tc.all;

import com.tc.factorybean.FactoryBeanObject;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2020/2/5 16:34
 * @Description:
 */
@Component
public class CustomerFactoryBean implements FactoryBean<FactoryBeanObj> {
    @Override
    public FactoryBeanObj getObject() throws Exception {
        return new FactoryBeanObj();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanObj.class;
    }
}
