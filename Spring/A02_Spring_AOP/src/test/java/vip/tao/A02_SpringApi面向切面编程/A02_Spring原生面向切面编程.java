package vip.tao.A02_SpringApi面向切面编程;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.tao.A02_SpringApi面向切面编程.Service.A02_UserInte;

public class A02_Spring原生面向切面编程 {
    @Test
    public void A02_Spring原生面向切面编程() {
        /**通过注解配置 类的类路径获获取spring容器的上下文*/
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("A02_SpringApi面向切面编程.xml");
        /**业务层传入，接口作为实现**/
        A02_UserInte a01_userImpl = ApplicationContext.getBean("A02_UserImpl", A02_UserInte.class);
        a01_userImpl.InsretUser();
        a01_userImpl.DeleteUser();

    }
}
