package vip.tao.A01_代理模式.A02_动态代理.mapper;

/**实现实体类的接口*/
public class A02_UserImpl implements A02_UserInte {


    @Override
    public void InsretUser() {
        System.out.println("添加用户");
    }

    @Override
    public void DeleteUser() {
        System.out.println("删除用户");
    }

    @Override
    public void UpdateUser() {
        System.out.println("修改用户");
    }

    @Override
    public void SelectUser() {
        System.out.println("查询用户");
    }
}
