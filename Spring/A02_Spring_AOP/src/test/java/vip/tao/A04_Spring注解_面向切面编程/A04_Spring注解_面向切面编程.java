package vip.tao.A04_Spring注解_面向切面编程;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.tao.A04_Spring注解_面向切面编程.Srevive.A04_UserInte;

public class A04_Spring注解_面向切面编程 {
    @Test
    public void A04_Spring注解_面向切面编程(){
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("A04_Spring注解面向切面编程.xml");
        A04_UserInte user = ApplicationContext.getBean("A04_UserImpl", A04_UserInte.class);
        user.SelectUser();
        user.SelectUser();
    }

}
