package vip.tao.A05_IOC_三种装配benans.A05_A02_java注解自动装配;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A05_A02_java注解自动装配 {

    @Test
    public void java注解自动装配() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("A02_java注解自动配装.xml");

        A05_A02_Person person = applicationContext.getBean("person", A05_A02_Person.class);
        //空指针异常 无法调用
        person.getCat().sleep();
        //空指针异常  无法调用
        person.getDog().sleep();
        System.out.println(person.getName());
    }
}
