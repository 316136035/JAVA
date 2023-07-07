package vip.tao.mapperTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.tao.A07_Spring_MyBatis_MVC_Mapper.UserMapper;
import vip.tao.Spring_MyBatis_MVC_Oom.User;

import java.util.List;
import java.util.function.Consumer;

public class mapperTest {
    @Test
    public void mapperTest_1() {
        /**获取spring容器的上下文（bean构造器就会被调用，创建了对象）*/
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**业务层传入（数据库持久层的实现类）作为动作实现**/
        UserMapper userMapper = ApplicationContext.getBean("UserMapperImpl_1", UserMapper.class);
        /**执行*SelectUser()方法 注意方法的返回值*/
        List<User> users = userMapper.SelectUser();
        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });


    }

//    @Test
//    public void mapperTest_2() {
//        /**获取spring容器的上下文（bean构造器就会被调用，创建了对象）*/
//        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        /**业务层传入（数据库持久层的实现类）作为动作实现**/
//        UserMapper userMapper = ApplicationContext.getBean("UserMapperImpl_2", UserMapper.class);
//        /**执行*SelectUser()方法*/
//        List<User> users = userMapper.SelectUser();
//        users.forEach(new Consumer<User>() {
//            @Override
//            public void accept(User user) {
//                System.out.println(user);
//            }
//        });
//
//
//    }
}
