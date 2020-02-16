package ioc.anno;

import java.lang.annotation.*;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 15:23
 * @Description:
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
}
