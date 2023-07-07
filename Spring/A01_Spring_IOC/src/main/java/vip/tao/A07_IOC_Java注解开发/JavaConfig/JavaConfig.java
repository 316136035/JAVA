package vip.tao.A07_IOC_Java注解开发.JavaConfig;

import org.springframework.context.annotation.*;
import vip.tao.A07_IOC_Java注解开发.oom实体类.A07_User;
@Configuration    /**Spring中的配置不依赖xml文件*/
@ComponentScan(basePackages = "vip.tao")  /**Spring扫描*/
//@Import("对象.class")  引入一个类
public class JavaConfig {
    /**Spring注入一个对象*/
    @Bean
    @Scope("singleton") //声明为单例
    public A07_User User(){
        return new A07_User();
    }
}
