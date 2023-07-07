package A01集合于JSON互转;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class A02Map集合于JSONObject互转 {
    public static void main(String[] args) {


        HashMap<String,String> HashMap = new HashMap<>();
        HashMap.put("Key1","valve1");
        HashMap.put("Key2","valve2");
        HashMap.put("Key3","valve3");
        /****************************Map集合转JSON对象*****************************************/
        JSONObject JSONObject= (JSONObject)JSON.toJSON(HashMap);
        System.out.println("打印JSON对象"+JSONObject.toJSONString());
        /**JSON对象获取参数*/
        System.out.println("JSON对象获取参数:"+JSONObject.get("Key1"));

        /****************************JSON对象转Map集合象*****************************************/
        String  JSONString="{\"Key2\":\"valve2\",\"Key1\":\"valve1\",\"Key3\":\"valve3\"}";
        /**JSON对象转Map集合象( JSON字符串,泛型)*/
        Map map = JSON.parseObject(JSONObject.toJSONString(), Map.class);
        System.out.println( map .toString());
        Map map1 = JSON.parseObject(JSONString, Map.class);
        System.out.println( map1 .toString());


    }
}
