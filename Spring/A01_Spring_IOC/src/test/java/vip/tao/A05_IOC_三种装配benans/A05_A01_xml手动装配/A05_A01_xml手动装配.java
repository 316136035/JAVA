package vip.tao.A05_IOC_三种装配benans.A05_A01_xml手动装配;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A05_A01_xml手动装配 {
    @Test
    public  void xml(){
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("A01_xml手动装配.xml");
        A05_A01_Person person = applicationContext.getBean("Person", A05_A01_Person.class);
        person.getCat().sleep();
        person.getDog().sleep();
    }

}
