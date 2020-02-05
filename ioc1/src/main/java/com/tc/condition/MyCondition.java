package com.tc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

import java.lang.annotation.Annotation;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 14:34
 * @Description:
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean exist = context.getBeanFactory().containsBeanDefinition("person");
        if (exist){
            return true;
        }
        return false;
    }
}
