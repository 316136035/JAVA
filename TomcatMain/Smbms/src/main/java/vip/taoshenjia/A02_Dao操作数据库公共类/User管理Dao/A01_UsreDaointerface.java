package vip.taoshenjia.A02_Dao操作数据库公共类.User管理Dao;

import vip.taoshenjia.A04_Model实体类.User;

import java.sql.Connection;
import java.util.List;

public interface A01_UsreDaointerface {
;
    /**获取用户总数量*/
    public long  Getcount(Connection connection,String text,int userRole);
    /**获取用户集合数量*/
    public List<User>  GetUserList(Connection connection, String text, int userRole,int currentPageNo,int pageSize);

    /**删除用户*/
    public long  DeleUserDao(Connection connection,String[] arr);






}
