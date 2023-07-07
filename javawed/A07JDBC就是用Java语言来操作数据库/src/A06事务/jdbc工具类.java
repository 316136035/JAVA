package A06事务;

import A04JdbcUtils高级工具类.处理异常的类;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbc工具类 {
    static String url;
    static String name;
    static String password;
    static String Driver;
    static {
        InputStream inputStream = null;

        try {
            inputStream = jdbc工具类.class.getClassLoader().getResourceAsStream("数据库工具类.properties");
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

    public static Connection 获取连接Connection() throws SQLException {

        加载sql驱动();
        Connection connection=null;

        connection = DriverManager.getConnection(url,name,  password);

        return connection;
    }




}
