

import java.sql.SQLException;

public class JdbcUtils初级工具类测试类 {
    public static void main(String[] args) {

       //预编译slq语句
        String sql = "select * from sqlzhuru   where sqlzhuru.USERNAME=? and sqlzhuru.PASSWORD=?";
        try {
            JdbcUtils初级工具类.获取执行sql语句的对象PreparedStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}