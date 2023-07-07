package vip.tao.A06_IOC_Spring注解开发.service业务层;

import org.springframework.stereotype.Service;

/**同等于在xml中配置 <bean id="user"  class="vip.tao.A06_IOC_Spring注解开发.oom实体类.A06_User"></bean>**/
@Service
public class A06_GetUserServicr {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
