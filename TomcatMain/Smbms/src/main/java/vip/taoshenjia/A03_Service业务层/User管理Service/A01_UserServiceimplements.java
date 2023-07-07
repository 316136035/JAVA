package vip.taoshenjia.A03_Service业务层.User管理Service;

import org.junit.Test;
import vip.taoshenjia.A02_Dao操作数据库公共类.User管理Dao.A01_UsreDaoimplements;
import vip.taoshenjia.A02_Dao操作数据库公共类.数据库工具类;
import vip.taoshenjia.A04_Model实体类.User;

import java.sql.Connection;
import java.util.List;
import java.util.function.Consumer;

public class A01_UserServiceimplements implements A01_UserServiceinterface {
   private A01_UsreDaoimplements a01_usreDaoimplements = null;

    public A01_UserServiceimplements() {
        a01_usreDaoimplements = new A01_UsreDaoimplements();
    }

    @Override
    public long GetCount(String text, int userRole) {
        long count = 0;
        Connection connection = null;
        try {

            connection = 数据库工具类.getConnection();
            count = a01_usreDaoimplements.Getcount(connection, text, userRole);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            数据库工具类.close(connection, null, null);
        }

        return count;
    }

    @Override
    public  List<User> GetUserList(String text, int userRole, int pageNo, int pageSize) {
        Connection connection = null;
        connection = 数据库工具类.getConnection();
        List<User> users = a01_usreDaoimplements.GetUserList(connection, text, userRole, pageNo, pageSize);
        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });

        return  users;
    }

    @Override
    public long DeleUserService(String[] arr) {
        Connection connection =null;
        long l = 0;
        try {
            connection = 数据库工具类.getConnection();
            System.out.println("DeleUserService");

            l = a01_usreDaoimplements.DeleUserDao(connection, arr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return l;
    }

    @Test
    public void test() {
        A01_UserServiceimplements a01_userServiceimplements = new A01_UserServiceimplements();
        a01_userServiceimplements.GetUserList(null,0,1,5);




    }
}
