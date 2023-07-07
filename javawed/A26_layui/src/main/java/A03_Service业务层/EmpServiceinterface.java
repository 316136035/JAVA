package A03_Service业务层;

import com.alibaba.fastjson.JSONObject;

import java.sql.Date;

public interface EmpServiceinterface {
    /**添加用户数据*/
    public  JSONObject addEmp(int id, String name, int age, int sex, Date date, int deptid);
    /**删除用户数据*/
    public JSONObject deleteEmp( int id);
    /**修改用户数据*/
    public JSONObject upDateEmp( int id, String name, int age, int sex, Date date, int deptid);


    /**查询用户数据 connection,  page页码,limit每页显示条数*/
    public JSONObject getEmp(int page, int limit);

    /**查询用户数据总数*/
    public int Getcount();

    /**查询部门数据*/
    public JSONObject GetEmprole();


}

