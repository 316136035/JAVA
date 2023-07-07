package com.cn.Dao持久层操作数据库.Dao持久层接口;

import com.cn.Model实体类.User;

public interface UserDaointerface {
    User getUser(String username,String password);
}
