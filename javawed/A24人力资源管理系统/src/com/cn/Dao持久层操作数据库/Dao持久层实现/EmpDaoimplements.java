package com.cn.Dao持久层操作数据库.Dao持久层实现;

import com.cn.Dao持久层操作数据库.Dao持久层接口.EmpDaointerface;
import com.cn.JdbcUtils获取数据库链接.JdbcUtils;
import com.cn.Model实体类.District;
import com.cn.Model实体类.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpDaoimplements implements EmpDaointerface {


    @Override
    public List<Emp> listEmp(Map<String, Object> params) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        // 创建一个集合
        List<Emp> list = new ArrayList<>();


        // sql语句
        String sql = "SELECT * FROM t_emp e LEFT JOIN t_district d ON e.districtid=d.id where 1=1 ";
        try {
            connection = JdbcUtils.getConnection();

            // 判断前台是否传递name
            if (params.get("name") != null && !params.get("name").equals("")) {
                sql += " and e.ename LIKE '%" + params.get("name") + "%'";
            }
            // 判断前台是否传递districtid
            if (params.get("district") != null && !params.get("district").equals("")) {
                sql += " and e.districtid = " + params.get("district");
            }
            sql += " limit " + params.get("start") + "," + params.get("pageSize");

            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Emp emp = new Emp(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getInt(4), resultSet.getDouble(5), resultSet.getDate(6),
                        resultSet.getDate(7), resultSet.getInt(8));
                District district = new District(resultSet.getInt(9), resultSet.getInt(10), resultSet.getString(11), resultSet.getInt(12));
                emp.setDistrict(district);
                list.add(emp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, statement, resultSet);


            return list;
        }


    }

    @Override
    public Integer countEmps(Map<String, Object> params) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        // 创建一个结果
        Integer count = 0;
        try {
            // 获取数据库链接
            connection = JdbcUtils.getConnection();
            // sql语句
            String sql = "SELECT count(1) FROM t_emp e where 1=1 ";
            // 判断前台是否传递qename
            if (params.get("name") != null && !params.get("name").equals("")) {
                sql += " and e.ename LIKE '%" + params.get("name") + "%'";
            }
            // 判断前台是否传递districtid
            if (params.get("district") != null && !params.get("district").equals("")) {
                sql += " and e.districtid = " + params.get("district");
            }
            System.out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, statement, resultSet);
        }
        return count;

    }


    @Override
    public void addEmp(Emp emp) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        /**从Navicat for MySQL复制*/
        String sql = "insert into t_emp values (?,?,?,?,?,?,?,?);";

        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, emp.getEname());
            preparedStatement.setInt(3, emp.getAge());
            preparedStatement.setInt(4, emp.getSex());
            preparedStatement.setDouble(5, emp.getSal());
            preparedStatement.setDate(6, new java.sql.Date(emp.getBirthday().getTime()));
            preparedStatement.setDate(7, new java.sql.Date(emp.getBirthday().getTime()));
            preparedStatement.setInt(8, Integer.valueOf(emp.getDistrictId()));
            System.out.println("插入:"+preparedStatement.toString());
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                System.out.println("插入成功!!!");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, preparedStatement);
        }


    }

    @Override
    public Emp selectEmp(String id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        /**从Navicat for MySQL复制*/
        String sql = "SELECT * FROM t_emp where id=?";
        Emp emp = null;
        try {
            connection = JdbcUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                emp = new Emp(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getInt(4), resultSet.getDouble(5), resultSet.getDate(6),
                        resultSet.getDate(7), resultSet.getInt(8));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, preparedStatement);
        }


        return emp;


    }

    @Override
    public void UpdateEmp(Emp emp) {

        String sql="UPDATE t_emp SET  ename=?, age=?, sex=?, sal=?, birthday=?, edate=?, districtid=? WHERE (id=?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, emp.getEname());
            preparedStatement.setInt(2, emp.getAge());
            preparedStatement.setInt(3, emp.getSex());
            preparedStatement.setDouble(4, emp.getSal());
            preparedStatement.setDate(5, new java.sql.Date(emp.getBirthday().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(emp.getBirthday().getTime()));
            preparedStatement.setInt(7, Integer.valueOf(emp.getDistrictId()));
            preparedStatement.setInt(8, emp.getId());

            System.out.println("修改SQL:"+preparedStatement.toString());
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                System.out.println("修改成功!!!");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, preparedStatement);
        }

    }

    @Override
    public void DelEmp(String id) {

        String sql="delete from t_emp where id=?;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            System.out.println("删除SQL:"+preparedStatement.toString());
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                System.out.println("删除成功!!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection, preparedStatement);
        }

    }


}
