package vip.tao.A01_IOC_控制反转_理论推导.A01_mapper数据库持久层;

public class A01_IUserMapperImp implements A01_IUserMapper {
    @Override
    public void getUser() {
        System.out.println("默认获取用户数据");
    }
}
