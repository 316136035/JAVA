package cn.tx.dao;

import cn.tx.model.District;

import java.util.List;

public interface DistrictDao {

    List<District> listDistrictByPid(Integer pId);
}
