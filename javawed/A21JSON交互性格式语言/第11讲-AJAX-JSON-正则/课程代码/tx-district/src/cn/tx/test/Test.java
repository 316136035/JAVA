package cn.tx.test;

import cn.tx.dao.DistrictDao;
import cn.tx.dao.DistrictDaoImpl;
import cn.tx.model.District;

import java.util.List;

public class Test {
    private static DistrictDao districtDao = new DistrictDaoImpl();
    public static void main(String[] args) {
        List<District> districts = districtDao.listDistrictByPid(12);
        System.out.println(districts);
    }
}
