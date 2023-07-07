package vip.taoshenjia.A02_Dao操作数据库公共类.UserLoginDao;

import vip.taoshenjia.A04_Model实体类.User;

import java.sql.Connection;

public interface A01_LoginDaointerface {

    /**判断账号密码的 接口（用户名userCode，数据库链接connection）*/
    public User getLoginUser(String userCode, Connection connection);


    /**修改密码 接口（用户名userCode，数据库链接connection）*/
    public int UserUpdate(int id, String password, Connection connection);




}
