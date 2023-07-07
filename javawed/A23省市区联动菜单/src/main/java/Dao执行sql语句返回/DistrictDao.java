package Dao执行sql语句返回;

import Model实体类.地址对象;

import java.util.List;

public interface DistrictDao {
    /**定于输入pid返回id的list集合接口*/
    List<地址对象> listDistrictByPid(Integer pId);
}
