package ioc.anno;

import java.lang.annotation.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 16:02
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}

