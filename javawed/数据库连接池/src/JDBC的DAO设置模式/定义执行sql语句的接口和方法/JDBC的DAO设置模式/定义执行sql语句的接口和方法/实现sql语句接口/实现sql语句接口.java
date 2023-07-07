package JDBC的DAO设置模式.定义执行sql语句的接口和方法.实现sql语句接口;

import JDBC的DAO设置模式.model对应数据库的实体类.JD;
import JDBC的DAO设置模式.定义执行sql语句的接口和方法.sql语句接口;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class 实现sql语句接口 implements sql语句接口 {

    @Override
    public void insert插入(JDBC的DAO设置模式.model对应数据库的实体类.JD jd) {
        String sql = "insert into JD values  (?,?,?,?,?);";
        PreparedStatement preparedStatement=null;

        try {

            preparedStatement = jdbc工具.数据库连接池的jdbc工具(sql);
            preparedStatement.setLong(1,jd.getSku());
            preparedStatement.setString(2,jd.getName());
            preparedStatement.setDouble(3,jd.getMonovalent1());
            preparedStatement.setDouble(4,jd.getMonovalent2());
            preparedStatement.setTimestamp(5,jd.getTimes());
            preparedStatement.executeUpdate();
            } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    Connection connection = preparedStatement.getConnection();
                    if (connection!=null){connection.close();}
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }



    @Override
    public void update修改(JD jd) {
        String sql = "update JD set name=?,Monovalent1=?,Monovalent2=?,times=? where sku=?";
        PreparedStatement preparedStatement=null;

        try {
            preparedStatement = jdbc工具.数据库连接池的jdbc工具(sql);
            preparedStatement.setString(1,jd.getName());
            preparedStatement.setDouble(2,jd.getMonovalent1());
            preparedStatement.setDouble(3,jd.getMonovalent2());
            preparedStatement.setTimestamp(4,jd.getTimes());
            preparedStatement.setLong(5,jd.getSku());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    Connection connection = preparedStatement.getConnection();
                    preparedStatement.close();
                    if (connection!=null){connection.close();}

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void delete删除(long sku) {
        PreparedStatement preparedStatement=null;
        String sql = "delete from JD where sku=?";
        try {
            preparedStatement = jdbc工具.数据库连接池的jdbc工具(sql);
            preparedStatement.setLong(1,sku);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    Connection connection = preparedStatement.getConnection();
                    preparedStatement.close();
                    if (connection!=null){connection.close();}

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public List<JD> 关键字查询(String str) {
        String sql="select * from JD where name like  '%"+str+"%' ";

        List<JD> List = new ArrayList();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
          //preparedStatement.setString(1,str);

            preparedStatement = jdbc工具.数据库连接池的jdbc工具(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long sku1 = resultSet.getLong(1);
                String name = resultSet.getString(2);
                double Monovalent1 = resultSet.getDouble(3);
                double Monovalent2 = resultSet.getDouble(4);
                Timestamp times = resultSet.getTimestamp(5);

                JD jd = new JD(sku1, name, Monovalent1, Monovalent2, times);
                List.add(jd);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    Connection connection = preparedStatement.getConnection();
                    preparedStatement.close();
                    if (connection!=null){connection.close();}

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return List;
    }

    @Override
    public void select查询(long sku) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql = "select sku,name,Monovalent1,Monovalent2,times from JD where sku=?";
        try {
            preparedStatement = jdbc工具.数据库连接池的jdbc工具(sql);
            preparedStatement.setLong(1,sku);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long sku1 = resultSet.getLong(1);
                String name = resultSet.getString(2);
                double Monovalent1 = resultSet.getDouble(3);
                double Monovalent2 = resultSet.getDouble(4);
                Timestamp times = resultSet.getTimestamp(5);
                System.out.println(sku1 +"  "+name+"  "+Monovalent1+"  "+Monovalent2+"  "+times );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    Connection connection = preparedStatement.getConnection();
                    preparedStatement.close();
                    if (connection!=null){connection.close();}

                } catch (SQLException e) {
                    e.printStackTrace();
                }
              }
        }

    }

    @Override
    public List<JD> select查询全部() {
        List<JD> List = new ArrayList();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql = "select * from JD ";
        try {
            preparedStatement = jdbc工具.数据库连接池的jdbc工具(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long sku1 = resultSet.getLong(1);
                String name = resultSet.getString(2);
                double Monovalent1 = resultSet.getDouble(3);
                double Monovalent2 = resultSet.getDouble(4);
                Timestamp times = resultSet.getTimestamp(5);

                JD jd = new JD(sku1, name, Monovalent1, Monovalent2, times);
                List.add(jd);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    Connection connection = preparedStatement.getConnection();
                    preparedStatement.close();
                    if (connection!=null){connection.close();}

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return List;
    }
}
