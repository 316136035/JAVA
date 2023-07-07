import A04JdbcUtils高级工具类.处理异常的类;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils高级获取数据工具类 {
    static String url;
    static String name;
    static String password;
    static String Driver;

    static {
        InputStream inputStream = null;

        try {
            inputStream =JdbcUtils高级获取数据工具类.class.getClassLoader().getResourceAsStream("数据库工具类.properties");

            Properties properties = new Properties();
            properties.load(inputStream);

            url = new String(properties.getProperty("url").getBytes("ISO-8859-1"), "gbk");
            name = properties.getProperty("username");
            password = properties.getProperty("password");
            Driver = properties.getProperty("Driver");

            System.out.println(url.toString());
            System.out.println(name);
            System.out.println(password);
            System.out.println(Driver.toString());


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

    public static Connection 获取连接Connection() throws SQLException {

        加载sql驱动();
        Connection connection=null;

        connection = DriverManager.getConnection(url,name,password);

        return connection;
    }

    public static void 获取执行sql语句的对象prepareStatement获取(String sql) {




        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet  result=null;
        try {
            connection = 获取连接Connection();
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while ( result.next()){

                int anInt = result.getInt(1);
                String string = result.getString(2);
                double aDouble = result.getDouble(3);
                Timestamp timestamp = result.getTimestamp(4);
                System.out.println( anInt+" "+string+" "+aDouble+" "+timestamp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            处理异常的类.closersc(result);
        }


    }
}
