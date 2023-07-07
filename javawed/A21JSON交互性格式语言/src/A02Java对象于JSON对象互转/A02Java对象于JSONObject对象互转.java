package A02Java对象于JSON对象互转;


import com.alibaba.fastjson.JSONObject;

public class A02Java对象于JSONObject对象互转 {
    public static void main(String[] args) {
        Java对象 手机 = new Java对象(1, "手机", 19.9);

        /**************Java对象转成JSON对象*********************/
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(手机);
        System.out.println("打印JSON对象"+jsonObject.toJSONString());


        /**************JSON对象转成Java对象*********************/
        String Java对象String="{\"money\":19.9,\"name\":\"手机\",\"sku\":1}";
        Java对象 java对象 = JSONObject.parseObject(jsonObject.toJSONString(), Java对象.class);
        System.out.println(java对象.toString());
        Java对象 java对象1 = JSONObject.parseObject(Java对象String,Java对象.class);
        System.out.println(java对象1 .toString());




    }
}
