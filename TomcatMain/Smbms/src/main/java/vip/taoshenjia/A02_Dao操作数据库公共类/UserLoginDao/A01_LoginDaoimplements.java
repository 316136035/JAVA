package vip.taoshenjia.A02_Dao操作数据库公共类.UserLoginDao;

import vip.taoshenjia.A04_Model实体类.User;
import vip.taoshenjia.A02_Dao操作数据库公共类.数据库工具类;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A01_LoginDaoimplements implements A01_LoginDaointerface {
    @Override
    public User getLoginUser(String userCode, Connection connection) {

        String  slq="SELECT * FROM `user` WHERE `userCode` = ?";
        Object[] params={userCode};
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User  user=null;


        if (connection!=null){
            try {
                resultSet = 数据库工具类.executeQuery(connection, slq,params, preparedStatement, resultSet);

                user = new User();
                if (resultSet.next()){
                    user.setId(resultSet.getInt("id"));
                    user.setUserCode(resultSet.getString("userCode"));
                    user.setUserName(resultSet.getString("userName"));
                    user.setUserPassword(resultSet.getString("userPassword"));
                    user.setGender(resultSet.getInt("gender"));
                    user.setBirthday(resultSet.getDate("birthday"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setAddress(resultSet.getString("address"));
                    user.setUserRole(resultSet.getInt("userRole"));
                    user.setCreatedBy(resultSet.getInt("createdBy"));
                    user.setCreationDate(resultSet.getDate("creationDate"));
                    user.setModifyBy(resultSet.getInt("modifyBy"));
                    user.setModifyDate(resultSet.getDate("modifyDate"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                数据库工具类.close(null, preparedStatement,resultSet);
            }

        }



        return  user;
    }

    @Override
    public int UserUpdate(int id, String password, Connection connection) {
        int i = 0;
        if (connection != null) {
            String slq = "UPDATE `user`  SET `userPassword`=? WHERE `id`=?";
            Object[] params = {password, id};
            PreparedStatement preparedStatement = null;

            try {
                System.out.println("********************"+ slq);
                i = 数据库工具类.executeUpdate(connection, slq, params, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                数据库工具类.close(null, preparedStatement, null);
            }
        }
        return i;
    }


}
