package com.tc.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 14:33
 * @Description:
 */
@Configuration
public class ConditionAppConfig {
    //@Bean
    public Person person(){
        return new Person();
    }
    @Bean
    @Conditional(MyCondition.class)
    public Cat cat(){
        return new Cat();
    }
}
