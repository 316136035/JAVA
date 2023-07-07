package com.cn.Dao持久层操作数据库.Dao持久层接口;


import com.cn.Model实体类.District;

import java.util.List;

public interface DistrictDaointerface {
    /**定于输入pid返回id的list集合接口*/
    List<District> listDistrictByPid(String pId);
}
