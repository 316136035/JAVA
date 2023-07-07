package A07数据库连接池;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static A07数据库连接池.A01_druid连接池.getConnection;

public class text {
    public static void main(String[] args) {


        //插入();
      // 读取();
       修改();
    }

    public static void 插入() {
        String sql = "INSERT INTO `text`  VALUES (NULL, '额我绕弯儿玩儿', '19',null );";
        PreparedStatement preparedStatement = null;
        Connection Connection1 = null;
        ResultSet resultSet = null;
        //获取链接
        try {
            Connection1 = getConnection();
            //获取执行SQL语句的对象
            preparedStatement = Connection1.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public static void 修改() {
        String sql = "UPDATE `text` SET NAME='周先生'  WHERE id = '62';";
        PreparedStatement preparedStatement = null;
        Connection Connection1 = null;
        ResultSet resultSet = null;
        //获取链接
        try {
            Connection1 = getConnection();
            //获取执行SQL语句的对象
            preparedStatement = Connection1.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
    public static void  读取() {

        String sql = "select * from text;";
        PreparedStatement preparedStatement = null;
        Connection Connection1 = null;
        ResultSet resultSet = null;
        try {
            //获取链接
            Connection1 = getConnection();
            //获取执行SQL语句的对象
            preparedStatement = Connection1.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getDouble(3));
                System.out.println(resultSet.getTimestamp(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();

                }

                // 把conn关闭了，其实连接池的底层已经对close方法进行增强。原来是销毁连接，现在是归还连接。
                if (Connection1 != null) {
                    Connection1.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
