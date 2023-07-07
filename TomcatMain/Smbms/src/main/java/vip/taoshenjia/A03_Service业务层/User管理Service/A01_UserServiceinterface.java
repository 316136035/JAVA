package vip.taoshenjia.A03_Service业务层.User管理Service;

import vip.taoshenjia.A04_Model实体类.User;

import java.util.List;

public interface A01_UserServiceinterface {
    /**获取用户总数量*/
    public long  GetCount( String text, int userRole);

    /**获取用户集合数量*/
    public List<User> GetUserList(String text, int userRole, int pageNo, int pageSize);

    /**删除用户*/
    public long  DeleUserService( String[] arr);



}
