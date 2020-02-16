import com.tc.all.AllAppConfig;
import com.tc.all.Cat;
import com.tc.bean.SimpleAppConfig;
import com.tc.bean.User;
import com.tc.beandefinitionregestor.ImportBeanDefinitionRegistrarAppConfig;
import com.tc.beanregister.BeanRegisterAppConfig;
import com.tc.beanregister.Monkey;
import com.tc.condition.ConditionAppConfig;
import com.tc.factorybean.FactoryBeanAppConfig;
import com.tc.importselector.ImportSelectorAppConfig;
import com.tc.importselector.ImportSelectorObject;
import com.tc.prototype.PrototypeAppConfig;
import com.tc.prototype.PrototypeObj;
import com.tc.xml.XmlObject;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 13:07
 * @Description:
 */
public class Test {




    @org.junit.Test
    public void testSimple(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleAppConfig.class);
        User bean = context.getBean(User.class);
        System.out.println(bean);
        User bean1 = (User)context.getBean("user");
        System.out.println(bean1);
    }
    @org.junit.Test
    public void testFactoryBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanAppConfig.class);
        System.out.println(context.getBean("myFactoryBean"));
        System.out.println(context.getBean("myFactoryBean"));
        System.out.println(context.getBean("&myFactoryBean"));
    }
    @org.junit.Test
    public void testImportSelector(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportSelectorAppConfig.class);
        System.out.println(context.getBean(ImportSelectorObject.class));
        System.out.println(context.getBean(ImportSelectorObject.class));
    }
    @org.junit.Test
    public void testImportBeanDefinitionRegistrar(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportBeanDefinitionRegistrarAppConfig.class);
        System.out.println(context.getBean("importBDRObject"));
        System.out.println(context.getBean("importBDRObject"));
    }
    @org.junit.Test
    public void testCondition(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionAppConfig.class);
        //System.out.println(context.getBean("person"));
        //System.out.println(context.getBean("cat"));
        System.out.println("==============");
    }

    @org.junit.Test
    public void testXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(context.getBean("xmlObject"));
        System.out.println(context.getBean("xmlObject1"));
        System.out.println(context.getBean("xmlObject2"));
        System.out.println(context.getBean("xmlObject3"));
        System.out.println(context.getBean("xmlObjectId"));

    }

    @org.junit.Test
    public void testXml2(){
        //创建一个bean注册器
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //创建bean定义读取器
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions("spring.xml");
        //String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        //System.out.println(Arrays.toString(beanDefinitionNames));
        String[] beanNamesForType = factory.getBeanNamesForType(XmlObject.class);
        System.out.println(Arrays.toString(beanNamesForType));
    }

    @org.junit.Test
    public void testBeanRegister(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanRegisterAppConfig.class);
        DefaultListableBeanFactory defaultListableBeanFactory = context.getDefaultListableBeanFactory();
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Monkey.class);
        rootBeanDefinition.getPropertyValues().add("name", "猴子王");
        rootBeanDefinition.setAutowireMode(3);
        defaultListableBeanFactory.registerBeanDefinition("monkeyRes",rootBeanDefinition);
        //填充属性
        //rootBeanDefinition.getPropertyValues().add("name", "猴子王");
        System.out.println(context.getBean("monkeyRes"));
    }
    @org.junit.Test
    public void testAll(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AllAppConfig.class);
        System.out.println("testAll finish.................");
        System.out.println(context.getBean("allAppConfig"));
    }

    @org.junit.Test
    public void testCatProxy(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AllAppConfig.class);
        Cat cat = (Cat)context.getBean(Cat.class);
        System.out.println(cat);
        cat.eat();
    }
    @org.junit.Test
    public void testPrototype(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrototypeAppConfig.class);
        System.out.println(context.getBean("componentProtoObject"));
        System.out.println(context.getBean("componentProtoObject"));
        System.out.println(context.getBean("componentProtoObject"));
    }
}
