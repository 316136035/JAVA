package vip.taoshenjia.A03_Service业务层.UserLoginService;

import vip.taoshenjia.A02_Dao操作数据库公共类.UserLoginDao.A01_LoginDaoimplements;
import vip.taoshenjia.A02_Dao操作数据库公共类.数据库工具类;
import vip.taoshenjia.A04_Model实体类.User;

import java.sql.Connection;

public class A01_LoginServiceimplements implements A01_LoginServiceinterface {
    private A01_LoginDaoimplements a01_loginDao登陆的implements = null;
    public A01_LoginServiceimplements() {
        /**创建Service业务层对象时---创建dao层对象*/
        a01_loginDao登陆的implements = new A01_LoginDaoimplements();
    }
    /**Service业务层对象方法*/
    @Override
    public User LoginService(String userCode, String password) {
        User loginUser = null;
        Connection connection = null;
        try {

            connection = 数据库工具类.getConnection();
            loginUser = a01_loginDao登陆的implements.getLoginUser(userCode, connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            数据库工具类.close(connection,null,null);

        }
        return loginUser ;
    }

    @Override
    public Boolean UserUpdate(int id, String password) {

        boolean flag=false;
        Connection connection = null;
        int i = 0;
        try {

            connection = 数据库工具类.getConnection();
            i = a01_loginDao登陆的implements.UserUpdate(id, password, connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            数据库工具类.close(connection,null,null);
        }
        if (i>0){
            flag=true;
        }
        return flag;
    }
}
