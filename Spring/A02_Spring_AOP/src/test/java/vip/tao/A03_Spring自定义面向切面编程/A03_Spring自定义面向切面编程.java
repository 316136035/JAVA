package vip.tao.A03_Spring自定义面向切面编程;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.tao.A03_Spring自定义面向切面编程.Srevive.A03_UserInte;

public class A03_Spring自定义面向切面编程 {
    @Test
    public void A03_Spring自定义面向切面编程(){
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("A03_Spring自定义面向切面编程.XML");
        A03_UserInte user = ApplicationContext.getBean("A03_UserImpl", A03_UserInte.class);
        user.SelectUser();
        user.SelectUser();
    }
}
