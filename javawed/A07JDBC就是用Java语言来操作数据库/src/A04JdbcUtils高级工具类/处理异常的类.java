package A04JdbcUtils高级工具类;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class 处理异常的类 {
    public static void closesc(Statement statement) {
        if (statement != null) {
            try {
                Connection connection = statement.getConnection();
                statement.close();
                if (connection != null) {
                    connection.close();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void closeio(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void closersc(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                Statement statement = resultSet.getStatement();
                resultSet.close();
                if (statement != null) {
                    Connection connection = statement.getConnection();

                    statement.close();
                    if (connection != null) {
                        connection.close();
                    }
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
