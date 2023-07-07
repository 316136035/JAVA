package A01集合Collection的体系_List_Set.Set无序集合_元素不可重复;


import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * 具有可预知迭代顺序的 Set 接口的哈希表和链接列表实现。此实现与 HashSet 的不同之外在于，
 * 后者维护着一个运行于所有条目的双重链接列表。此链接列表定义了迭代顺序，即按照将元素插入到 set 中的顺序（插入顺序）进行迭代。
 * 特点：
 1.元素唯一性
 2.有序的
 3.允许null存在一个
 4.不是线程安全（效率高）
 **/
public class A02LinkedHashSet_不是线程安全_有序的 {
    public static void main(String[] args) {

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        linkedHashSet.add("C");
        linkedHashSet.add("D");
        linkedHashSet.add("E");
        linkedHashSet.add("F");
        System.out.println(linkedHashSet);


    }
}
