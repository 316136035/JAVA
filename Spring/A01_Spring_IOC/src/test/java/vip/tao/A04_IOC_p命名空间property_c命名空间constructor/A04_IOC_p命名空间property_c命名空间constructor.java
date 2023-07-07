package vip.tao.A04_IOC_p命名空间property_c命名空间constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A04_IOC_p命名空间property_c命名空间constructor {
    @Test
    public void Spring创建对象() {
        /**   IOC控制反转参数  **/
        /**获取spring容器的上下文（bean构造器就会被调用，创建了对象）*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("P_C_beans.xml");
        /**业务层传入（数据库持久层的实现类）作为动作实现**/
        A04_User a04_user1 = applicationContext.getBean("A04_User", A04_User.class);
        A04_User a04_user2 = applicationContext.getBean("A04_User", A04_User.class);

        System.out.println(a04_user1 == a04_user2);
        System.out.println(a04_user1 .toString());




    }

}
