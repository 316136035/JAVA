package com.cn.mapper;

import com.cn.oom.User1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper1 {


    public List<User1> selectUser();

    public User1 selectUserId(@Param("User_id") int User_id);

    public int insretUser(User1 User1);

    public int deleteUser(@Param("User_id") int User_id);

    public int updateUser(User1 User1);


}
