package vip.tao.A06_IOC_Spring注解开发;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.tao.A06_IOC_Spring注解开发.mapper持久层.A06_User;


public class A06_IOC_Spring注解开发 {
    @Test
    public  void  A06_IOC_Spring注解开发(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("A06_IOC_Spring注解开发.xml");
        /**user的名称为类名名称的小写*/
        A06_User a06_user = applicationContext.getBean("a06_User", A06_User.class);
        System.out.println(a06_user.toString());

    }
}
