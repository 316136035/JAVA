package vip.tao.A02_IOC_容器使用xml配置文件;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.tao.A02_IOC_容器使用xml配置文件.A02_Service业务层.A02_UserService;

public class A02_IOC_容器使用Test {
    @Test
    public void Spring控制反转参数() {
        /**   IOC控制反转参数  **/
        /**获取spring容器的上下文（bean构造器就会被调用，创建了对象）*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**业务层传入（数据库持久层的实现类）作为动作实现**/
        A02_UserService a02_userService = applicationContext.getBean("A02_UserService", A02_UserService.class);
        /**调用业务层的方法*/
        a02_userService.SelectUser();


    }





}
