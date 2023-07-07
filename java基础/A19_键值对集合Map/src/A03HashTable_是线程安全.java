import java.util.Hashtable;

/**
 * HashTable的特点
 1. HashTable是map的实现类
 2.不允许任何null值和null键
 3. HashTable中的元素没有顺序（跟添加的顺序无关）
 4. HashTable是线程安全的。
 */
public class A03HashTable_是线程安全 {
    public static void main(String[] args) {

        Hashtable<String, String> Hashtable= new Hashtable<>();
        Hashtable.put("白日鼠","白胜");
        Hashtable.put("豹子头","林冲");
        Hashtable.put("小诸葛","福安");
        Hashtable.put("A","a");
        Hashtable.put(null,"null");
        Hashtable.put("key","valve");
    }
}
