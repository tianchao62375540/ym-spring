package com.tc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: tianchao
 * @Date: 2020/2/20 23:28
 * @Description:
 */
@Component
public class SpringMailListener implements ApplicationListener<SpringMaillEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(SpringMaillEvent event) {
        System.out.println(event.getContext());
        System.out.println(event);
    }
}
