package vip.tao.A05_IOC_三种装配benans.A05_A03_Spring注解自动装配;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A05_A03_Spring注解自动装配 {
    @Test
    public  void  Spring注解自动装配(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("A03_Spring注解自动配装.xml");

        A05_A03_Person person = applicationContext.getBean("Person", A05_A03_Person.class);
        person.getCat().sleep();
        person.getDog().sleep();
        System.out.println(person.getName());
    }
}
