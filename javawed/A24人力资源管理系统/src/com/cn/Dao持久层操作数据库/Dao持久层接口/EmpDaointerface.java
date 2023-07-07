package com.cn.Dao持久层操作数据库.Dao持久层接口;

import com.cn.Model实体类.Emp;

import java.util.List;
import java.util.Map;

public interface EmpDaointerface {
    List<Emp> listEmp(Map<String, Object> params);

    Integer countEmps(Map<String, Object> params);

    void addEmp(Emp emp);

    Emp selectEmp(String id);

    void UpdateEmp(Emp emp);

    void DelEmp(String id);

}
