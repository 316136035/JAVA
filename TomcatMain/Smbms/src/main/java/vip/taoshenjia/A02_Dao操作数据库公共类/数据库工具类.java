package vip.taoshenjia.A02_Dao操作数据库公共类;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class 数据库工具类 {
    // 连接池对象
    private static DataSource DATA_SOURCE;

    static {
        // 加载属性文件
        Properties pro = new Properties();
        InputStream inputStream = 数据库工具类.class.getResourceAsStream("/druid.properties");
        try {
            // 加载属性文件
            pro.load(inputStream);
            // 创建连接池对象
            DATA_SOURCE = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库链接
     */
    public static Connection getConnection()  {
        Connection connection = null;

        try {
            connection = DATA_SOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 编写查询公共方法
     */
    public static ResultSet executeQuery(Connection connection ,String sql, Object[] params, PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        /**获取预编译对象  （通过传参的数组设置）*/
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        System.out.println("执行sql："+preparedStatement.toString());
        /**获取结果集*/
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    /**
     * 编写增删改公共方法
     */

    public static int executeUpdate(Connection connection, String sql, Object[] params, PreparedStatement preparedStatement) throws SQLException {

        preparedStatement = connection.prepareStatement(sql);
        /**获取预编译对象 （通过传参的数组设置）*/
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);

        }
        /**获取结果集*/
        int Update = preparedStatement.executeUpdate();
        return Update;
    }

    /**异常处理类*/
    public static boolean close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;
        try {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        }
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
                preparedStatement = null;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        }
        try {
            if (connection != null) {
                connection.close();
                connection = null;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            flag = false;
        }


        return flag;
    }

 

}
