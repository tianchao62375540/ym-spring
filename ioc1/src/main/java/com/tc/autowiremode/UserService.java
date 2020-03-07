package com.tc.autowiremode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Auther: tianchao
 * @Date: 2020/2/20 20:32
 * @Description:
 */
@Component
public class UserService {
    @Autowired
    UserDaoOne userDaoTwo;

    @PostConstruct
    public void postContrust(){
        System.out.println(userDaoTwo.getClass().getName());
    }

}
