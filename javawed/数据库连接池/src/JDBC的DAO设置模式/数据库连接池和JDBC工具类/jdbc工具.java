

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Properties;

public class jdbc工具 {
    public static   PreparedStatement 数据库连接池的jdbc工具(String sql) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DataSource dataSource=null;
        Properties properties = new Properties();
        //1.加载配置文件
        InputStream is = jdbc工具.class.getClassLoader().getResourceAsStream("数据库连接池工具类高级版.properties");

        try {
            //1.加载配置文件
            properties.load(is);
            //读取properties文本并创建数据库连接池工厂
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        //使用数据库连接池工厂获取 connection对象
        connection = dataSource.getConnection();
        // 使用connection对象获取执行sql语句的对象
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }

}
