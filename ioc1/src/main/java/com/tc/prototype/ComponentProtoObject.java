package com.tc.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2020/2/7 20:42
 * @Description:
 */
@Component
@Scope("prototype")
public class ComponentProtoObject {
    public ComponentProtoObject(){
        System.out.println("=================================ComponentProtoObject============================");
    }
}
