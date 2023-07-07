package vip.tao.A03_IOC_容器xml创建对象;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.tao.A03_IOC_容器xml创建对象.A03_Oom实体类.A03_User;

public class Spring创建对象 {
    @Test
    public void Spring创建对象() {
        /**   IOC控制反转参数  **/
        /**获取spring容器的上下文（bean构造器就会被调用，创建了对象）*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**业务层传入（数据库持久层的实现类）作为动作实现**/
        A03_User a03_user1 = applicationContext.getBean("A03_User", A03_User.class);
        A03_User a03_user2 = applicationContext.getBean("A03_User", A03_User.class);

        System.out.println(a03_user1 == a03_user2);
        System.out.println(a03_user1 .toString());




    }

}
