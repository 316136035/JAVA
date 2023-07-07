package A01集合Collection的体系_List_Set.集合的泛型;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class A01集合的泛型 {
    public static void main(String[] args) {

        /**在定义集合的时候
         List<数据类型> 变量名 = new ArrayList<数据类型>();
         */
        /**String就是泛型(只能存指定类型的参数)*/
        ArrayList<String> strings = new ArrayList<>();
        LinkedList<String> strings1 = new LinkedList<>();
        Vector<String> strings2 = new Vector<>();


        List<Person> list = new ArrayList<>();

        Person p1 = new Person(1, "周先生", 19);

        List<Person> list1 = new ArrayList<>();
        Person p2 = new Person(2, "黄先生", 18);

        list.add(p1);
        list1.add(p2);

        /**集合中添加另一个集合的元素 在继承的情况中就可以*/
        list.addAll(list1 );
        System.out.println(list);


    }
}
