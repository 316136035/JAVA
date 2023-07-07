import java.util.Hashtable;
import java.util.LinkedHashMap;

/**LinkedHashMap的特点
 1. LinkedHashMap是map的实现类
 2.允许多个null值和一个null键
 3. LinkedHashMap有顺序（添加的顺序）
 4. LinkedHashMap不是线程安全的。
 */
public class A04LinkedHashMap_不是线程安全_有序 {
    public static void main(String[] args) {

        LinkedHashMap<String, String> LinkedHashMap= new LinkedHashMap<>();
        LinkedHashMap.put("白日鼠","白胜");
        LinkedHashMap.put("豹子头","林冲");
        LinkedHashMap.put("小诸葛","福安");
        LinkedHashMap.put("A","a");
        LinkedHashMap.put(null,"null");
        LinkedHashMap.put("key","valve");
    }
}
