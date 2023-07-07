package vip.tao.Spring_Mybatis_Affairs.mapper;

import vip.tao.Spring_Mybatis_Affairs.oom.User;

import java.util.List;

public interface UserMapper {
    List<User> SelectUser();

    public int  InsretUser(User user);
    public int  DeleteUser(int id);
    public int  UpdateUser();

}

