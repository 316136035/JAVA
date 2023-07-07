package A05JdbcUtils时间类;

import A04JdbcUtils高级工具类.处理异常的类;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class sql插入时间类 {


    static String url;
    static String name;
    static String password;
    static String Driver;

    static {
        InputStream inputStream = null;

        try {
            inputStream = sql插入时间类.class.getClassLoader().getResourceAsStream("数据库工具类.properties");
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
        System.out.println( Driver.toString());
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

    public static void 获取执行SQL语句的对象prepareStatement插入(String sql) {
        加载sql驱动();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = 获取Connection连接对象();
            java.util.Date parse = new SimpleDateFormat("yyyy-mm-dd").parse("1991-12-31");
            System.out.println(parse.getTime());

            preparedStatement = connection.prepareStatement(sql);
            //设置日期
            preparedStatement.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            //设置时分秒
            preparedStatement.setTime(2, new Time(System.currentTimeMillis()));
            //设置日期和时分秒
            preparedStatement.setTimestamp(3, null);
            preparedStatement.executeUpdate();
            System.out.println("执行完毕");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            处理异常的类.closesc(preparedStatement);
        }

    }


}
