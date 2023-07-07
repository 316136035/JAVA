package A02JDBC预编译slq语句;


import java.sql.*;

public class JDBC预编译slq语句 {
    public static void main(String[] args) {

        预编译slq语句("admin", "admin");
    }

    static String url = "jdbc:mysql://zhouyuting.tpddns.cn:3306/text?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static String username1 = "root";
    static String password1 = "dog34994963";
    //加载驱动用的
    static String Driver = "com.mysql.cj.jdbc.Driver";

    public static void 预编译slq语句(String name, String word) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {  //加载驱动
            Class.forName(Driver);
            //建立连接
            connection = DriverManager.getConnection(url, username1, password1);
            //预编译slq语句（zhuru别名）
            String sql = "select * from sqlzhuru  zhuru where zhuru.USERNAME= ? and zhuru.PASSWORD=? ;";
            //预编译slq语句
            preparedStatement = connection.prepareStatement(sql);
            //预编译slq语句后添加账号名和密码
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,word);
            //执行SQL语句并放回结果集(结果集只能用一次)
            ResultSet resultSet1 = preparedStatement.executeQuery();

            if (resultSet1.next()) {
                System.out.println("密码正确");

                } else {
                System.out.println("密码不正确");

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           JDBC预编译slq语句异常工具类.slq语句异常(resultSet,  preparedStatement, connection);
        }


    }
}
