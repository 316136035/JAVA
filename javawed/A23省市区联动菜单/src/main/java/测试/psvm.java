package 测试;

import Service业务层服务处理.DistrictServiceImpl;
import com.alibaba.fastjson.JSONArray;

public class psvm {
    public static void main(String[] args) {

        // 创建一个Service对象
        DistrictServiceImpl districtService = new DistrictServiceImpl();

        // 从service对象获取下级地区的集合
        JSONArray jsonArray = districtService.listDistrict(Integer.valueOf(4744));
        System.out.println(jsonArray.toJSONString());


//




    }
}
