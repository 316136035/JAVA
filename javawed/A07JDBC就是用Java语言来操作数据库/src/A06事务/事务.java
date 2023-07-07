package A06事务;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 事务 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            connection = jdbc工具类.获取连接Connection();
            //这个是设置事务隔离级别  connection.setTransactionIsolation(事务隔离级别);
            // 查看隔离级别
            int transactionIsolation = connection.getTransactionIsolation();
            System.out.println(transactionIsolation );
            //设置隔离级别
            connection.setTransactionIsolation(2);
            int transactionIsolation1 = connection.getTransactionIsolation();
            System.out.println(transactionIsolation1 );


            //这是转出钱的sql
            String sql = "update shiwu set shiwu.balance=shiwu.balance-? where shiwu.id=?;";

            //connection设置自动提交为false
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1000);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();


             //  int i = 10 / 0;
            //这是收钱的sql
            String sql1 = "update shiwu set shiwu.balance=shiwu.balance+? where shiwu.id=?;";
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setInt(1, 1000);
            preparedStatement1.setInt(2, 2);
            preparedStatement1.executeUpdate();

            //如果没有异常就提交
            connection.commit();

        } catch (Exception e) {

            try {
                System.out.println("出现异常提交不上");
                //如果出现异常 connection就回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement1 != null) {
                    preparedStatement1.close();
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
}
