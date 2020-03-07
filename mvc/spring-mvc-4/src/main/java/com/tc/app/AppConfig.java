package com.tc.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Auther: tianchao
 * @Date: 2020/2/21 23:31
 * @Description:
 */
@Configuration
@ComponentScan("com.tc")
public class AppConfig implements WebMvcConfigurer {


    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /*@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        System.out.println("==========================registry=================================");
        registry.jsp("/", ".jsp");
    }*/
}
