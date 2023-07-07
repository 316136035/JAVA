package cn.tx.service;

import cn.tx.dao.DistrictDao;
import cn.tx.dao.DistrictDaoImpl;
import cn.tx.model.District;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class DistrictServiceImpl implements DistrictService {
    // 创建一个dao的对象
    DistrictDao districtDao = new DistrictDaoImpl();
    @Override
    public JSONArray listDistrict(Integer pId) {
        // 获取地区实体类集合
        List<District> list = districtDao.listDistrictByPid(pId);
        // 把实体类集合 转换成JSONArray
        JSONArray jsonArray = (JSONArray) JSON.toJSON(list);
        return jsonArray;
    }
}
