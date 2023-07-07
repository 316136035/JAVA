import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DriverManager类连接mysql插入修改数据 {
    static String url = "jdbc:mysql://192.168.100.5:3306/xxy?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static String username = "root";
    static String password = "dog34994963";
    //加载驱动用的
    static String Driver = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {
        连接mysql插入数据修改数据删除数据();
    }


    public static void 连接mysql插入数据修改数据删除数据() {
        Connection connection = null;
        Statement statement = null;
        try {
            //加载驱动
            Class.forName(Driver);
            //和sql创建连接得到connection
            connection = DriverManager.getConnection(url, username, password);
            // 插入数据修改数据删除数据就数修改sql语句-----
            //插入数据sql语句
           String sql = "insert into person values (NULL ,'资生堂','广州','2021-06-17',NULL );";
            // 修改数据sql语句
             //String sql = "update person set NAME='我是修改出来的名字' where NAME='资生堂';";
            // 删除数据sql语句
            //String sql = "delete from person where id=1;";

            //通过connection获取到可以执行SLQ语句的对象
            statement = connection.createStatement();
            //执行SLQ语句
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            连接mysql处理异常的方法.连接mysql插入修改删除数据和读取数据处理异常的方法(connection,statement);
        }

    }


}
