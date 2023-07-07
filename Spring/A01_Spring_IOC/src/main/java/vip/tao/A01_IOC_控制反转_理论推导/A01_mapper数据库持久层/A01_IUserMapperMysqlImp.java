package vip.tao.A01_IOC_控制反转_理论推导.A01_mapper数据库持久层;

public class A01_IUserMapperMysqlImp implements A01_IUserMapper {
    @Override
    public void getUser() {
        System.out.println("链接Mysql实现");
    }
}
