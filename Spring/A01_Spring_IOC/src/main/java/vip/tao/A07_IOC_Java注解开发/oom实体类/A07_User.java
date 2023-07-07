package vip.tao.A07_IOC_Java注解开发.oom实体类;

import org.springframework.beans.factory.annotation.Value;


public class A07_User {

    @Value("周先生")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
