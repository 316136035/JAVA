package com.cn.Service业务层.Service业务层接口;

import com.cn.Model实体类.Emp;
import com.cn.Utils工具类.Page;

import java.util.Map;

public interface EmpServiceinterface {
    Page<Emp> listEmp(Map<String, Object> params);

    void addEmp(Emp emp);
    Emp  selectEmp(String id);

    void UpdateEmp(Emp emp);

    void DelEmp(String id);





}
