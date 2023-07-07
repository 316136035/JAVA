package vip.tao.A06_IOC_Spring注解开发.oom实体类;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**同等于在xml中配置 <bean id="user"  class="vip.tao.A06_IOC_Spring注解开发.oom实体类.A06_User"></bean>**/
@Controller
@Scope("singleton")  //声明为单例
public class A06_User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
