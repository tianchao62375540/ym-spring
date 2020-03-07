package com.tc.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Auther: tianchao
 * @Date: 2020/2/20 23:28
 * @Description:
 */
public class SpringMaillEvent extends ApplicationEvent  {

    String context;

    public SpringMaillEvent(Object source) {
        super(source);
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
