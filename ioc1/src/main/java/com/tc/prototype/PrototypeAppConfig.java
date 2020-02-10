package com.tc.prototype;

import org.springframework.context.annotation.*;

import javax.swing.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/7 15:18
 * @Description:
 */
@Configuration
@ComponentScan("com.tc.prototype")
public class PrototypeAppConfig {


    @Bean
    @Scope("prototype")
    public PrototypeObj prototypeObj(){
        return new PrototypeObj();
    }
}
