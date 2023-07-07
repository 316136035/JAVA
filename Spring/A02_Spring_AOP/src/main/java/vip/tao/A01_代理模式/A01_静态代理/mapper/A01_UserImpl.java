package vip.tao.A01_代理模式.A01_静态代理.mapper;

/**实现实体类的接口*/
public class A01_UserImpl implements A01_UserInte {

    @Override
    public void Insret() {
        System.out.println("添加用户");

    }

    @Override
    public void Delete() {
        System.out.println("删除用户");
    }

    @Override
    public void Update() {
        System.out.println("修改用户");
    }

    @Override
    public void SelectUser() {
        System.out.println("删除用户");
    }
}
