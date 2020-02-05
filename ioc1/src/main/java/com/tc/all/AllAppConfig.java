package com.tc.all;

import org.springframework.context.annotation.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/5 16:32
 * @Description:
 */
@Configuration
@ComponentScan("com.tc.all")
@Import(value = {ImportGenObj.class,CustomerImportSelector.class, CustomerImportBeanDefinitionRegistrar.class})
public class AllAppConfig {

    @Bean
    public BeanMethodObject beanMethodObject(){
        return new BeanMethodObject();
    }
}
