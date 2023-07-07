package vip.tao.A05_IOC_三种装配benans.A05_A03_Spring注解自动装配;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class A05_A03_Person {

    private String name;

    /**Autowired自动注入（要配置xxml文件为开启注解注入）是通过反射byname的方式实现**/
    @Autowired()
    private A05_A03_Dog Cat;
    /**Autowired自动注入（要配置xxml文件为开启注解注入）是通过反射byname的方式实现**/
    @Autowired
    @Qualifier(value = "Cat")  /**指定xml中的bean的对象名字*/
    private A05_A03_Cat Dog;



    public String getName() {
        return name;
    }

    public A05_A03_Dog getCat() {
        return Cat;
    }

    public A05_A03_Cat getDog() {
        return Dog;
    }
}
