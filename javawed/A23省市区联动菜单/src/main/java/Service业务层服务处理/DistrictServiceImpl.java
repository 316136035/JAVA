package Service业务层服务处理;

import Dao执行sql语句返回.DistrictDao;
import Dao执行sql语句返回.DistrictDaoImpl;
import Model实体类.地址对象;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;


import java.util.List;

public class DistrictServiceImpl implements  DistrictService{
    // 创建一个DistrictDaoImpl对象，  用于执行SQL语句返回据库结果集的数据表
    DistrictDao districtDao = new DistrictDaoImpl();
    @Override
    public JSONArray listDistrict(Integer pId) {

        // 执行SQL语句返回据库结果集的数据表
        List<地址对象> list = districtDao.listDistrictByPid(Integer.valueOf(pId));
        // 把实体类集合 转换成JSONArray
        JSONArray JSONArray = (JSONArray)JSON.toJSON(list);
        return JSONArray;
    }
}
