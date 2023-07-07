package vip.taoshenjia.A02_Dao操作数据库公共类.Role角色Dao;

import vip.taoshenjia.A02_Dao操作数据库公共类.数据库工具类;
import vip.taoshenjia.A04_Model实体类.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class A01_RoleDaoimplements implements A01_RoleDaointerface {
    @Override
    public List GetRoleList(Connection connection) {
        List<Role> roleList = new ArrayList<>();
        if ( connection!=null) {
            String sql = "SELECT * FROM role";
            Object[] params = {};
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                resultSet = 数据库工具类.executeQuery(connection, sql, params, preparedStatement, resultSet);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String roleCode = resultSet.getString(2);
                    String roleName = resultSet.getString(3);
                    int createdBy = resultSet.getInt(4);
                    Date creationDate = resultSet.getDate(5);
                    int modifyBy = resultSet.getInt(6);
                    Date modifyDate = resultSet.getDate(7);
                    Role role = new Role(id, roleCode, roleName, createdBy, creationDate, modifyBy, modifyDate);
                    roleList.add(role);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                数据库工具类.close(null, preparedStatement, resultSet);

            }
        }
        return roleList;
    }




}
