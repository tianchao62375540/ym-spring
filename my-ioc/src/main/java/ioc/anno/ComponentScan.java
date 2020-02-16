package ioc.anno;

import java.lang.annotation.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 15:51
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ComponentScan {
    String value() default "";
}
