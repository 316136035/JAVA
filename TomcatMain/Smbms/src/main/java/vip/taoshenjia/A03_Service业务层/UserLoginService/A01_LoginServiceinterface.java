package vip.taoshenjia.A03_Service业务层.UserLoginService;

import vip.taoshenjia.A04_Model实体类.User;

public interface A01_LoginServiceinterface {
    /**用户登陆的Service业务层*/
    public User LoginService(String userCode ,String  password);


    /**根据用户ID修改用户密码Service业务层*/
    public Boolean  UserUpdate(int id ,String  password);

}
