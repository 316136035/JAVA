package com.cn.Service业务层.Service业务层实现;

import com.cn.Dao持久层操作数据库.Dao持久层实现.UserDaoimplements;
import com.cn.Model实体类.User;
import com.cn.Service业务层.Service业务层接口.UserServiceinterface;
import com.cn.Utils工具类.MD5Utils;

public class UserServiceimplements implements UserServiceinterface {
    /*** 注入一个Dao对象*/
    UserDaoimplements userDaoimplements = new UserDaoimplements();
    @Override
    public User getUser(String username, String password) {
        String MD5password = MD5Utils.encrypt(password);//获取通过MD5加密后的 字符串
        return userDaoimplements.getUser(username, MD5password);
    }
}
