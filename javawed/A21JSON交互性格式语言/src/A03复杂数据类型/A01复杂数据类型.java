package A03复杂数据类型;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class A01复杂数据类型 {
    public static void main(String[] args) {

        //创建map集合
        Map<String, Object> HashMap = new HashMap<>();
        HashMap.put("mapkey1", "panvalve1");
        HashMap.put("mapkey2", "panvalve2");
        //创建List集合
        List<Java对象1> list = new ArrayList<>();
        list.add(new Java对象1(1, "手机", 100));
        list.add(new Java对象1(2, "电视", 200));
        list.add(new Java对象1(3, "电视", 300));

        System.out.println(list);

        //map集合存放List集合
        HashMap.put("listJava对象",list);


        System.out.println("打印List集合:"+list);
        // 将map对象转换成JSON字符串
        String jsonString = JSON.toJSONString(HashMap);
        System.out.println("将map对象转换成JSON字符串:"+jsonString);

        /*****************************************************************************/

        /**先把JSON字符串转换成JsonObject*/
        JSONObject jsonObject= (JSONObject)JSONObject.parse(jsonString);
        /**获取JSONArray对象*/
        JSONArray jsonArray = (JSONArray) jsonObject.get("listJava对象");
        /**解析JSONArray对象获取Java对象1集合*/
        List<Java对象1> lists = JSONArray.parseArray(jsonArray.toJSONString(), Java对象1.class);
        lists.forEach(new Consumer<Java对象1>() {
            @Override
            public void accept(Java对象1 java对象1) {
                System.out.println(java对象1.toString());
            }
        });
        /*****************************************************************************/

        /** 直接转换的话,data内的集合为JSONArray,List集合内存储的为JSONObject*/
        Map map = JSONObject.parseObject(jsonString, Map.class);
        /**获取listJava对象并转成 JSONArray对象*/
        JSONArray jsonArray1 = (JSONArray)map.get("listJava对象");
        /**JSONArray对象转成list*/
        List<Java对象1> lists1 = JSONArray.parseArray(jsonArray1.toJSONString(), Java对象1.class);
        System.out.println("JSONArray对象转成list*"+lists1);


        /*替换MAP数据*/
        map.put("listJava对象",lists1);
        map.put("listJava对象",lists);

        System.out.println(map);

    }
}
