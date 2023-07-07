package A05JdbcUtils时间类;

import A04JdbcUtils高级工具类.处理异常的类;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class sql获取时间类 {
    static String url;
    static String name;
    static String password;
    static String Driver;

    static {
        InputStream inputStream = null;

        try {
            inputStream = sql获取时间类.class.getClassLoader().getResourceAsStream("数据库工具类.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            url = new String(properties.getProperty("url").getBytes("ISO-8859-1"), "gbk");
            name = properties.getProperty("username");
            password = properties.getProperty("password");
            Driver = properties.getProperty("Driver");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            处理异常的类.closeio(inputStream);
        }
    }

    public static void 加载sql驱动() {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection 获取Connection连接对象() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, name, password);
        return connection;
    }

    public static void 获取执行SQL语句的对象prepareStatement获取(String sql) {
        加载sql驱动();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = 获取Connection连接对象();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (  resultSet.next()){
                //填写表里面的名称也可以   1.2 .3.4 也可以
                Date riqi = resultSet.getDate(1);
                Time time1 = resultSet.getTime(2);
                Timestamp times = resultSet.getTimestamp(3);


                System.out.print("日期="+riqi);
                System.out.print("时间="+time1 );
                System.out.print("年月日时分秒="+times );


            }



            System.out.println("执行完毕");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            处理异常的类.closersc(resultSet);
        }

    }


}
