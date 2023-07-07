package vip.tao.A02_IOC_容器使用xml配置文件.A02_Service业务层;

import vip.tao.A02_IOC_容器使用xml配置文件.A02_mapper数据库持久层.A02_UserMapper;

public class A02_UserServiceImpl implements A02_UserService{
    /**定义一个mapper数据库持久层的接口作为参数的传达*/
    private A02_UserMapper userMapper;
    /***提供给xml文件的set注入*/
    public void setA02_UserMapper(A02_UserMapper A02_UserMapper) {
        this.userMapper=A02_UserMapper;
    }
    @Override
    public void SelectUser() {
       userMapper.SelectUser();
        System.out.println(userMapper.toString());
    }
}
