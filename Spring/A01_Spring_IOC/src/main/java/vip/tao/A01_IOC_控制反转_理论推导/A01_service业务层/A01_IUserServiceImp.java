package vip.tao.A01_IOC_控制反转_理论推导.A01_service业务层;

import vip.tao.A01_IOC_控制反转_理论推导.A01_mapper数据库持久层.A01_IUserMapper;

public class A01_IUserServiceImp implements A01_IUserService {
    /**定义一个mapper数据库持久层的接口作为参数的传达*/
    private A01_IUserMapper userMapper;
    public void setUserMapper(A01_IUserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public void getUser() {
        userMapper.getUser();
    }
}
