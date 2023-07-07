package com.cn.Service业务层.Service业务层实现;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;


import com.cn.Dao持久层操作数据库.Dao持久层实现.DistrictDaoimplements;
import com.cn.Model实体类.District;
import com.cn.Service业务层.Service业务层接口.DistrictServiceinterface;


import java.util.List;

public class DistrictServiceimplements  implements DistrictServiceinterface {

    /*** 注入一个Dao对象*/
    DistrictDaoimplements DistrictDaoimplements = new DistrictDaoimplements();
    @Override
    public JSONArray getaddress(String pid) {
        List<District> list =  DistrictDaoimplements.listDistrictByPid(pid);
        // 把实体类集合 转换成JSONArray
        JSONArray JSONArray = (JSONArray) JSON.toJSON(list);

      //  System.out.println(JSONArray.toJSONString());
        return  JSONArray;
    }
}
