package vip.taoshenjia.A03_Service业务层.Role角色Service;

import com.alibaba.fastjson.JSONArray;
import vip.taoshenjia.A02_Dao操作数据库公共类.Role角色Dao.A01_RoleDaoimplements;
import vip.taoshenjia.A02_Dao操作数据库公共类.数据库工具类;
import vip.taoshenjia.A04_Model实体类.Role;

import java.sql.Connection;
import java.util.List;

public class A01_RoleServiceimplements implements A01_RoleServiceinterface {
    private  A01_RoleDaoimplements A01_RoleDaoimplements=null;
    public A01_RoleServiceimplements() {

        A01_RoleDaoimplements = new A01_RoleDaoimplements();
    }

    /**获取角色对象的集合*/
    @Override
    public String GetRoleList() {
        Connection connection = null;
        List<Role> list = null;
        try {
            connection = 数据库工具类.getConnection();
            list = A01_RoleDaoimplements.GetRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            数据库工具类.close(connection,null,null);
        }
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
        return jsonArray.toJSONString();
    }



}
