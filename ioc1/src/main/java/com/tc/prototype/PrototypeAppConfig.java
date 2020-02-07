package com.tc.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.swing.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/7 15:18
 * @Description:
 */
@Configuration
public class PrototypeAppConfig {


    @Bean
    @Scope("prototype")
    public PrototypeObj prototypeObj(){
        return new PrototypeObj();
    }
}
