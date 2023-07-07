import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

/**
 * 该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序，具体取决于使用的构造方法。
 * TreeMap特点：
 * 可以按着key来做排序
 * Key不能null，
 * key不能重复，值可以有多个null
 * 不是线程安全的
 */
public class A02TreeMap_不是线程安全_自定义排序 {
    public static void main(String[] args) {

        TreeMap<Person, String> TreeMap = new TreeMap<>();
        TreeMap.put(new Person(3, "周先生", 19), "第1个");
        TreeMap.put(new Person(7, "周先生", 19), "第2个");
        TreeMap.put(new Person(1, "周先生", 19), "第3个");
        TreeMap.put(new Person(8, "周先生", 19), "第4个");
        /**
         /**排序对象,对象要实现 Comparable<T>接口  重写compareTo()方法
         */


        TreeMap.entrySet().forEach(new Consumer<Map.Entry<Person, String>>() {
            @Override
            public void accept(Map.Entry<Person, String> personStringEntry) {
                System.out.println(personStringEntry);
            }
        });






    }
}
