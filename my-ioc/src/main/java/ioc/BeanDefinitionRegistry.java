package ioc;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 14:57
 * @Description:
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
            throws Exception;
}
