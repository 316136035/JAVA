package vip.tao.A04_Spring注解_面向切面编程.Srevive;

/**实现实体类的接口*/
public class A04_UserImpl implements A04_UserInte {


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
