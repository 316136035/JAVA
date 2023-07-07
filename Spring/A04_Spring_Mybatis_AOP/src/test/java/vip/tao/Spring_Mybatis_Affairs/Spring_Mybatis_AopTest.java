package vip.tao.Spring_Mybatis_Affairs;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.tao.Spring_Mybatis_Affairs.mapper.UserMapper;
import vip.tao.Spring_Mybatis_Affairs.oom.User;

import java.util.List;
import java.util.function.Consumer;

public class Spring_Mybatis_AopTest {
    @Test
    public void SelectUser()
    {/**获取spring容器的上下文（bean构造器就会被调用，创建了对象）*/
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**业务层传入（数据库持久层的实现类）作为动作实现**/
        UserMapper userMapper = ApplicationContext.getBean("UserMapperImpl", UserMapper.class);
        /**执行*SelectUser()方法*/
        List<User> users = userMapper.SelectUser();
        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });


    }

    @Test
    public void 事务测试()
    {/**获取spring容器的上下文（bean构造器就会被调用，创建了对象）*/
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**业务层传入（数据库持久层的实现类）作为动作实现**/
        UserMapper userMapper = ApplicationContext.getBean("UserMapperImpl", UserMapper.class);
        /**同时执行2个sql 一个出错就全回滚*/
        userMapper.InsretUser(null);


    }



}
