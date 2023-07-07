


import java.sql.*;

public class DriverManager类连接mysql读取数据 {


    public static void main(String[] args) {

        读取数据();
    }

    static String url = "jdbc:mysql://192.168.100.5:3306/xxy?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static String username = "root";
    static String password = "dog34994963";
    //加载驱动用的
    static String Driver = "com.mysql.jdbc.Driver";
    public static void 读取数据() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //加载驱动
            Class.forName(Driver);
            //获取connection对象
            connection = DriverManager.getConnection(url, username, password);
            //通过connection对象获取执行sql语句的方法
            statement = connection.createStatement();
            //编写sql语句
            String sql = "select * from person WHERE ADDR='广州';";
            //执行sql语句并放回结果集
            resultSet = statement.executeQuery(sql);
            //遍历结果集
            while (resultSet.next()) {
                //获取值
                long id = resultSet.getLong("P_ID");
                //获取值
                String name = resultSet.getString("NAME");
                //获取值
                String ADDR = resultSet.getString("ADDR");
                //获取值
                Date Date = resultSet.getDate("DATE");

                Timestamp times = resultSet.getTimestamp("times");
                System.out.println(id + name + ADDR + Date+times);
                }
                } catch (Exception e) {
            e.printStackTrace();
        } finally {
            连接mysql处理异常的方法.连接mysql插入修改删除数据和读取数据处理异常的方法(connection, statement, resultSet);
        }

    }
}
