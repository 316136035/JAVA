package vip.tao.A07_IOC_Java注解开发;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.tao.A07_IOC_Java注解开发.JavaConfig.JavaConfig;
import vip.tao.A07_IOC_Java注解开发.oom实体类.A07_User;

public class A07_IOC_Java注解开发 {

    @Test
    public void A07_IOC_Java注解开发() {
        /**通过注解配置 类的类路径获获取spring容器的上下文*/
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        /**配置扫描路径*/
        ((AnnotationConfigApplicationContext) annotationConfigApplicationContext).scan("vip.tao");

        A07_User user = annotationConfigApplicationContext.getBean(A07_User.class);
        System.out.println(user.getName());
    }
}
