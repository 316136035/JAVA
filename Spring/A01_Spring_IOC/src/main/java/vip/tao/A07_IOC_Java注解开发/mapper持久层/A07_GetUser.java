package vip.tao.A07_IOC_Java注解开发.mapper持久层;

import org.springframework.stereotype.Repository;

/**同等于在xml中配置 <bean id="user"  class="vip.tao.A06_IOC_Spring注解开发.oom实体类.A06_User"></bean>**/
@Repository
public class A07_GetUser {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
