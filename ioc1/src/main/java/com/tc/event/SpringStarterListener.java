package com.tc.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2020/2/20 22:52
 * @Description:
 */
@Component
public class SpringStarterListener implements ApplicationListener<ContextStartedEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println(event.getSource());
        ApplicationContext applicationContext = event.getApplicationContext();
        //int i = 1/0;
        System.out.println(event);
    }
}
