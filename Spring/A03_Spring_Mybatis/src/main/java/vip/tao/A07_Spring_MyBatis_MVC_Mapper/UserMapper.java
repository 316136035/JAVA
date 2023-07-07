package vip.tao.A07_Spring_MyBatis_MVC_Mapper;

import vip.tao.Spring_MyBatis_MVC_Oom.User;

import java.util.List;

public interface UserMapper {
    public List<User> SelectUser();

    public void InsretUser();

    public void DeleteUser();

    public void UpdateUser();


}
