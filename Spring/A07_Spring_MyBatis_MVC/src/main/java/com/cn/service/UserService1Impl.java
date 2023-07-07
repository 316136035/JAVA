package com.cn.service;


import com.cn.mapper.UserMapper1;
import com.cn.oom.User1;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class UserService1Impl implements UserService1 {

    private UserMapper1 userMapper1;

    public void setUserMapper1(UserMapper1 userMapper1) {
        this.userMapper1 = userMapper1;
    }


    @Override
    public List<User1> SelectUser() {
        return userMapper1.selectUser();
    }

    @Override
    public User1 SelectUserId(int User_id) {
        return userMapper1.selectUserId(User_id);
    }

    @Override
    public int InsretUser(User1 User1) {
        return userMapper1.insretUser(User1);
    }

    @Override
    public int DeleteUser(int User_id) {
        return userMapper1.deleteUser(User_id);
    }

    @Override
    public int UpdateUser(User1 User1) {
        return userMapper1.updateUser(User1);
    }
}
