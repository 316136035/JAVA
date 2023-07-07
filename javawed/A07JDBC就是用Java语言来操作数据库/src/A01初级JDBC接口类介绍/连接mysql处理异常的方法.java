

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class 连接mysql处理异常的方法 {
    public static void 连接mysql插入修改删除数据和读取数据处理异常的方法(Connection connection, Statement statement, ResultSet resultSet ) {
        try {
            if (connection != null) {

                    connection.close();
                    }

            if (statement != null) {

                    statement.close();
            }

            if (resultSet != null) {

                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void 连接mysql插入修改删除数据和读取数据处理异常的方法(Connection connection, Statement statement ) {
        try {
            if (connection != null) {

                connection.close();
            }

            if (statement != null) {

                statement.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
