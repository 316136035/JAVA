package com.cn.service;

import com.cn.oom.User1;

import java.util.List;

public interface UserService1 {
    public List<User1> SelectUser();
    public User1 SelectUserId( int User_id);
    public int InsretUser(User1 User1);
    public int DeleteUser(int User_id);
    public int UpdateUser(User1 User1);
}
