package A02JDBC预编译slq语句;

import java.sql.*;

public class JDBC预编译slq语句异常工具类 {
    public static void slq语句异常(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
