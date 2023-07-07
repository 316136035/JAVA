package A07数据库连接池;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class A01_druid连接池 {

    // 连接池对象
    private static DataSource DATA_SOURCE;

    static{
        // 加载属性文件
        Properties pro = new Properties();
        InputStream inputStream = A01_druid连接池.class.getResourceAsStream("/druid.properties");
        try {
            // 加载属性文件
            pro.load(inputStream);
            // 创建连接池对象
            DATA_SOURCE = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获取链接
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DATA_SOURCE.getConnection();
        return connection;
    }




}