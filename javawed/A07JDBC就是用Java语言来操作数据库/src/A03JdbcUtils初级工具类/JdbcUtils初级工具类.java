

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils初级工具类 {

    static String url;
    static String username;
    static String password;
    //加载驱动用的
    static String driver;

    //静态加载
    static {
        Properties properties = new Properties();
        //获取src下的文件资源流
        InputStream inputStream = JdbcUtils初级工具类.class.getClassLoader().getResourceAsStream("数据库工具类.properties");
        try {
            //把资源流加载到properties中
            properties.load(inputStream);
            //解决properties中文乱码
            url = new String(properties.getProperty("url").getBytes("ISO-8859-1"), "gbk");
            //获取 properties的键值对值
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("Driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void 加载SQL驱动() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection 获取Connection连接对象() {

        Connection connection = null;
        try {
            加载SQL驱动();
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return connection;
    }

    public static void 获取执行sql语句的对象PreparedStatement(String sql) throws SQLException {
        PreparedStatement preparedStatement = null;

        Connection connection = 获取Connection连接对象();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "123");
        preparedStatement.setString(2, "12");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登陆成功!!");
        } else {
            System.out.println("密码错误!!");
        }

        JdbcUtils初级工具类.closes(preparedStatement);

    }

    public static void closes(Statement statement) {
        if (statement != null) {
            try {
                Connection connection = statement.getConnection();
                statement.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
