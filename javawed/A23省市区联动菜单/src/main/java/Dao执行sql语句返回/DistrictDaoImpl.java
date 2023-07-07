package Dao执行sql语句返回;

import JdbcUtils创建sql连接池返回链接.JdbcUtils;
import Model实体类.地址对象;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**  实现输入pid返回id的list集合接口*/
public class DistrictDaoImpl implements DistrictDao {
    @Override
    public List<地址对象> listDistrictByPid(Integer pId) {

        Connection connection = null; //获取链接
        PreparedStatement preparedStatement = null;  //预编译Sql
        ResultSet resultSet = null;//执行查询sql语句（返回数据库结果集的数据表）
        //创建list集合存放List<地址对象>
        List<地址对象> districts = new ArrayList<>();
        String sql = "select * from addressall where pid = ? order BY id";

        try {
            //获取链接
            connection = JdbcUtils.getConnection();
            //预编译Sql
            preparedStatement = connection.prepareStatement(sql);
            //设置预编译SQl语句
            preparedStatement.setInt(1, Integer.valueOf(pId));
            //执行查询sql语句（返回数据库结果集的数据表）
            resultSet = preparedStatement.executeQuery();
            //读取据库结果集的数据表
            while (resultSet.next()) {
                //创建址对象并设置参数
                地址对象 地址对象 = new 地址对象(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4));
                //集合存放List<地址对象>
                districts.add(地址对象);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JdbcUtils.close(connection, preparedStatement, resultSet);
        }


        return districts;
    }
}
