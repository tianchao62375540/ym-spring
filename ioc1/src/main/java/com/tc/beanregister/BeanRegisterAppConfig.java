package com.tc.beanregister;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 16:45
 * @Description:
 */
@Configuration
public class BeanRegisterAppConfig {

   @Bean
   public TaoZi taoZi(){
       return new TaoZi();
   }

    @Bean
    public XiangJiao xiangJiao(){
        return new XiangJiao();
    }
}
