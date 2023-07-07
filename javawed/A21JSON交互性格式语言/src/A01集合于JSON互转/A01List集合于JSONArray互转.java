package A01集合于JSON互转;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class A01List集合于JSONArray互转 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        /**********************list集合转JSONArray**********************/
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
        //JSONArray添加数据
        jsonArray.add("E");
        //JSONArray删除数据
        jsonArray.remove(4);
        System.out.println("打印jsonArray：" + jsonArray.toJSONString());


        /**********************JSONArray转list集合**********************/
        String listString = "[\"A\",\"B\",\"C\",\"D\"]";
        List<String> lists = JSONArray.parseArray(jsonArray.toJSONString(), String.class);
        System.out.println(lists);
        List<String> lists1 = JSONArray.parseArray(listString, String.class);
        System.out.println(lists1);




    }
}
