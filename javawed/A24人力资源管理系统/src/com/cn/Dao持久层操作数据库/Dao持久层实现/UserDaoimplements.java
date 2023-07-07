package com.cn.Dao持久层操作数据库.Dao持久层实现;

import com.cn.Dao持久层操作数据库.Dao持久层接口.UserDaointerface;
import com.cn.JdbcUtils获取数据库链接.JdbcUtils;
import com.cn.Model实体类.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoimplements implements UserDaointerface {
    @Override
    public User getUser(String username, String password) {
        Connection connection =null;//获取数据库链接
        PreparedStatement preparedStatement = null;  //预编译Sql
        ResultSet resultSet = null;//执行查询sql语句（返回数据库结果集的数据表）

        User user = null;//创建User实体类对象
        String sql = "select * from user where username=? and password=?";
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            preparedStatement = connection.prepareStatement(sql);//预编译Sql
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();//执行sql(返回数据)
            if ( resultSet.next()){
                user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }

        return user;
    }


}
