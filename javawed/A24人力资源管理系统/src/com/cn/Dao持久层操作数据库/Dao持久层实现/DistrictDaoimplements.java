package com.cn.Dao持久层操作数据库.Dao持久层实现;


import com.cn.Dao持久层操作数据库.Dao持久层接口.DistrictDaointerface;
import com.cn.JdbcUtils获取数据库链接.JdbcUtils;
import com.cn.Model实体类.District;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictDaoimplements implements DistrictDaointerface {
    @Override
    public List<District> listDistrictByPid(String pId) {
        Connection connection =null;//获取数据库链接
        PreparedStatement preparedStatement = null;  //预编译Sql
        ResultSet resultSet = null;//执行查询sql语句（返回数据库结果集的数据表）


       List<District> list = new ArrayList<>();
        String sql = "select * from  t_district where  pid=?";
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            preparedStatement = connection.prepareStatement(sql);//预编译Sql
            preparedStatement.setString(1,String.valueOf(pId));

            resultSet = preparedStatement.executeQuery();//执行sql(返回数据)
            while (resultSet.next()){
                list.add(new District( resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,preparedStatement,resultSet);
        }




        return  list;
    }


}
