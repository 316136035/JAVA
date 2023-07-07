package com.cn.servicr;

import com.cn.oom.User1;
import com.cn.service.UserService1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.function.Consumer;

public class mapperTest {
    @Test
    public void mapperTest_1() {
        /**获取spring容器的上下文（bean构造器就会被调用，创建了对象）*/
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**业务层传入（数据库持久层的实现类）作为动作实现**/
        UserService1 userService1Impl = ApplicationContext.getBean("UserService1Impl", UserService1.class);
        /**执行*SelectUser()方法 注意方法的返回值*/
        List<User1> users = userService1Impl.SelectUser();
        users.forEach(new Consumer<User1>() {
            @Override
            public void accept(User1 user) {
                System.out.println(user);
            }
        });


    }


}
