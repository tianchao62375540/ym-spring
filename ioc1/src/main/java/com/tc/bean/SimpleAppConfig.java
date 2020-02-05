package com.tc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 13:08
 * @Description:
 */
@Configuration
@ComponentScan("com.tc.bean")
public class SimpleAppConfig {
    @Bean
    public User user(){
        return new User();
    }
}
