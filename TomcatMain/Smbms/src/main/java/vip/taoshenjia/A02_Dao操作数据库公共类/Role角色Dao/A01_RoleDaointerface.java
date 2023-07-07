package vip.taoshenjia.A02_Dao操作数据库公共类.Role角色Dao;

import vip.taoshenjia.A04_Model实体类.Role;

import java.sql.Connection;
import java.util.List;

public interface A01_RoleDaointerface {
    /**获取角色表*/
    public List<Role> GetRoleList(Connection connection);








}
