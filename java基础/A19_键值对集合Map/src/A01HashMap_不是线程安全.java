import java.util.*;


/**
 * 1.数据成对出现
 * 2.数据的键是唯一的
 * 3.一个键只能对应一个值
 * 4.值可以重复
 * 5.键允许有一个为空，值可以多个是空。
 * 6.Map也是无序的
 * 7.不是线程安全的
 * */
public class A01HashMap_不是线程安全 {
    public static void main(String[] args) {

        HashMap<String, String> hashMap= new HashMap<>();
        hashMap.put("白日鼠","白胜");
        hashMap.put("豹子头","林冲");
        hashMap.put("小诸葛","福安");
        hashMap.put("A","a");
        hashMap.put(null,"null");
        hashMap.put("key","valve");
        /**如果存在相同的key,原有的key对应的valve的值就会被修改*/
        hashMap.put("A","....");

        /** HashMap的方法**/
        HashMap<String, String> hashMap1= new HashMap<>();
        hashMap1.put("ABC","abcc");
        /** 集合中添加另一个集合的元素*/
        hashMap.putAll(hashMap1);

        /**清空集合*/
        //hashMap.clear();
        /**从此映射中删除指定键的映射（如果存在）*/
        hashMap.remove("白日鼠");
        /**集合的获取*/
        System.out.println(hashMap.get(null));

        /**获取集合的全部Key*/
        Set<String> keys = hashMap.keySet();
        System.out.println(keys);

        /**获取集合的全部valve*/
        Collection<String> values = hashMap.values();
        System.out.println(values);

        /**遍历map集合*/
        for (String s : hashMap.keySet()) {
            System.out.println(hashMap.get(s));
        }

        /**判断集合是否包含key*/
        System.out.println("判断集合是否包含key:"+hashMap.containsKey("key"));
        /**判断集合是否包含valve*/
        System.out.println("判断集合是否包含valve:"+hashMap.containsValue("Value"));
        /**判断集合是否为空*/
        System.out.println("判断集合是否为空:"+hashMap.isEmpty());


        /**遍历map集合的每一组数据*/
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            /**获取每一key和valve*/
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }


        /**hashMap不是线程安全转成线程安全*/
        Collections.synchronizedMap(hashMap);
        System.out.println(hashMap);







    }
}
