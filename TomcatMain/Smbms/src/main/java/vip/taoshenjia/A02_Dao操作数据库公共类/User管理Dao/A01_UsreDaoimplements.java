package vip.taoshenjia.A02_Dao操作数据库公共类.User管理Dao;

import com.mysql.cj.util.StringUtils;
import org.junit.Test;
import vip.taoshenjia.A02_Dao操作数据库公共类.数据库工具类;
import vip.taoshenjia.A04_Model实体类.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class A01_UsreDaoimplements implements A01_UsreDaointerface {

    @Override
    public long Getcount(Connection connection, String text, int userRole) {
        int anInt=0;
        if (connection!=null){

            String sql = "SELECT  COUNT(1) FROM user u,role r WHERE u.userRole=r.id";
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(sql);
            List<Object> list = new ArrayList<>();
            if (!StringUtils.isNullOrEmpty(text)) {
                stringBuffer.append(" AND u.userName LIKE ?");

                list.add("%"+text+"%");

            }
            if (userRole > 0) {
                stringBuffer.append(" AND u.userRole= ?");
                list.add(userRole);
            }
            Object[] params = list.toArray();
            try {
                resultSet = 数据库工具类.executeQuery(connection, stringBuffer.toString(), params, preparedStatement, resultSet);
                if (resultSet.next()){
                    anInt = resultSet.getInt(1);
                }
                System.out.println(resultSet.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                数据库工具类.close(null, preparedStatement, resultSet);
            }
        }



        return anInt ;
    }

    @Override
    public List<User>  GetUserList(Connection connection, String text, int userRole, int currentPageNo, int pageSize) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> Userlist = new ArrayList<>();
        if (connection!=null){
            /**创建可变字符串*/
            StringBuffer stringBuffer = new StringBuffer();
            /**创建list集合用于存放前台传参的数据*/
            List<Object> list = new ArrayList<>();
            /**sql语句*/
            stringBuffer.append("SELECT  * FROM user u,role r WHERE u.userRole=r.id  ");
            /**判断是否关键字查询*/
            if (!StringUtils.isNullOrEmpty(text)) {
                /**添加关键字查询*/
                stringBuffer.append(" AND u.userName LIKE ?");
                /**拼接?的数据*/
                list.add("%"+text+"%");

            }
            /**判断获取角色编码*/
            if (userRole > 0) {
                stringBuffer.append(" AND u.userRole= ?");
                list.add(userRole);
            }
            /**分页查询的sql语句*/
            stringBuffer.append(" ORDER BY userCode  LIMIT ?,? ;");
            currentPageNo = (currentPageNo - 1) * pageSize;

            if (currentPageNo<0){
                currentPageNo=0;
            }
            list.add(currentPageNo);
            list.add(pageSize);

            /**可变字符串转成字符串**/
            String sql = stringBuffer.toString();
            /**集合转成数组**/
            Object[] params = list.toArray();
            try {
                resultSet = 数据库工具类.executeQuery(connection, sql, params, preparedStatement, resultSet);
                while (resultSet.next()){

                    int id = resultSet.getInt(1);
                    String userCode = resultSet.getString(2);
                    String userName = resultSet.getString(3);
                    String userPassword = resultSet.getString(4);
                    int gender = resultSet.getInt(5);
                    Date birthday = resultSet.getDate(6);
                    String phone = resultSet.getString(7);
                    String address = resultSet.getString(8);
                    int userRole1 = resultSet.getInt(9);
                    int createdBy = resultSet.getInt(9);
                    Date creationDate = resultSet.getDate(10);
                    int modifyBy = resultSet.getInt(11);
                    Date modifyDate = resultSet.getDate(12);
                    String roleName = resultSet.getString("roleName");
                    User user = new User(id,userCode, userName,userPassword,gender,birthday, phone,address ,userRole1 ,createdBy,creationDate,modifyBy,modifyDate,roleName);
                    Userlist.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();}
        }

        return Userlist ;
    }

    @Override
    public long DeleUserDao(Connection connection,String[] arr) {


        int inited=0;
        PreparedStatement preparedStatement = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DELETE FROM `Smbms`.`user` WHERE `id` IN()");
        int i1 = stringBuffer.indexOf("(") + 1;
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.insert(i1,"?,");
        }
        int i = stringBuffer.lastIndexOf(",");
        stringBuffer = stringBuffer.delete(i, i + 1);

        if (connection!=null){
            try {

                //connection设置自动提交为false
                connection.setAutoCommit(false);
                inited = 数据库工具类.executeUpdate(connection, stringBuffer.toString(), arr, preparedStatement);

                //如果没有异常就提交
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("出现异常提交不上");
                //如果出现异常 connection就回滚
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }


        }


        return inited;
    }

    @Test
    public void test(){

        DeleUserDao(数据库工具类.getConnection(),new  String[]{"1","2","3","4","5"});
    }

}
