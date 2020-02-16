package ioc;

import ioc.anno.Autowired;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 14:56
 * @Description:
 */
public class DefaultListableBeanFactory implements BeanDefinitionRegistry,BeanFactory{

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    private volatile List<String> beanDefinitionNames = new ArrayList<>(256);


    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(beanName, beanDefinition);
        beanDefinitionNames.add(beanName);
    }

    @Override
    public Object getBean(String name) throws Exception {
        //从缓存中获取
        Object object = singletonObjects.get(name);
        if (object != null){
            return object;
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition ==null){
            throw new Exception(" No beanName named : "+name);
        }
        //创建bean实例
        object = createBean(beanDefinition);
        if (object != null){
            // 注入依赖
            inject(object);

            //将实例化的bean放入缓存中
            singletonObjects.put(name,object);
        }
        return object;
    }

    private void inject(Object bean) throws Exception {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            String fieldName = field.getName();
            if (beanDefinitionNames.contains(fieldName)){
                if(field.isAnnotationPresent(Autowired.class)){
                    Object dependencyBean = getBean(fieldName);
                    //为对象中的属性赋值
                    field.setAccessible(true);
                    field.set(bean,dependencyBean);
                }
            }
        }
    }

    @Override
    public Object createBean(BeanDefinition beanDefinition) throws Exception {
        String className = beanDefinition.getClassName();
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        }catch (ClassNotFoundException e){
            throw new Exception(" No bean named : "+className);
        }
        return clazz.newInstance();
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws Exception {
        for (String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getClassName().equals(requiredType.getName())){
                return (T)getBean(beanName);
            }
        }
        return null;
    }

    public void preInstantiateBeans() {
        List<String> beanNames = this.beanDefinitionNames;
        for(String beanName: beanNames){
            try {
                getBean(beanName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
