package ioc;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 15:00
 * @Description:
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    Object createBean(BeanDefinition beanDefinition) throws Exception;

    <T> T getBean(Class<T> requiredType) throws Exception;
}
