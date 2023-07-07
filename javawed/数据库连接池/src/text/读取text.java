package text;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class 读取text {
    public static void main(String[] args)  {
        String sql = "select * from stu;";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Properties properties = new Properties();
        //1.加载配置文件
        InputStream is = 读取text.class.getClassLoader().getResourceAsStream("数据库连接池工具类高级版.properties");
        try {
            //1.加载配置文件
            properties.load(is);
            //读取properties文本并创建数据库连接池工厂
            DataSource   dataSource = DruidDataSourceFactory.createDataSource(properties);
            //使用数据库连接池工厂获取 connection对象
            connection = dataSource.getConnection();
            // 使用connection对象获取执行sql语句的对象
            preparedStatement = connection.prepareStatement(sql);

            //执行sql语句,获得结果集
            resultSet = preparedStatement.executeQuery();
            //遍历结果集
            while (resultSet.next()) {
                long id1 = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double money = resultSet.getDouble("math");
                System.out.println(id1 + name + money);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet!=null){resultSet.close();}
                if (preparedStatement!=null){preparedStatement.close();}
                if (connection!=null){connection.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}
