package A02_Dao操作数据库;

import A04_实体类.Emp;
import A04_实体类.Emprole;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface EmpDaointerface {
    /**添加用户数据*/
    public int addEmp(Connection connection, int id, String name, int age, int sex, Date date, int deptid);
    /**删除用户数据*/
    public int deleteEmp(Connection connection, int id);
    /**修改用户数据*/
    public int upDateEmp(Connection connection, int id, String name, int age, int sex, Date date, int deptid);

    /**查询用户数据 connection,  page页码,limit每页显示条数*/
   public List<Emp> getEmp(Connection connection, int page,int limit);
    /**查询用户数据总数*/
    public int Getcount(Connection connection);
    /**查询部门数据*/
    public List<Emprole> GetEmprole(Connection connection);








}
