import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class A03集合工具类Collections {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        list.add(new Person(1, "周先生", 19));
        list.add(new Person(2, "黄先生", 19));
        list.add(new Person(3, "何先生", 19));
        list.add(new Person(4, "郭先生", 19));


        /**反转指定列表中元素的顺序。**/
        Collections.reverse(list);
        System.out.println(list);

        /**使用默认的随机源随机排列指定的列表。*/
        Collections.shuffle(list);
        System.out.println(list);

        /**排序对象,对象要实现 Comparable<T>接口  重写compareTo()方法
         */


        /**排序对象*****使用外部比较器 Comparator*/
        外部比较器Comparator 外部比较器Comparator = new 外部比较器Comparator();
        Collections.shuffle(list, 外部比较器Comparator);
        System.out.println("使用外部比较器:" + list);


        /**排序对象*****使用类部类比较器 Comparator*/
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int retur = o1.getId() - o2.getId();
                if (retur == 0) {
                    retur = o1.getName().compareTo(o2.getName());
                }
                return retur;
            }
        });
        System.out.println("使用类部类比较器:" + list);


        /**把List转成线程安全*/
        Collections.synchronizedList(list);


    }
}
