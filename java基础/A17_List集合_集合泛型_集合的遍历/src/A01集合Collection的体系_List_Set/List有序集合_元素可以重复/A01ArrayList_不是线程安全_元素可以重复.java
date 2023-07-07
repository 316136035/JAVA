package A01集合Collection的体系_List_Set.List有序集合_元素可以重复;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * List 接口的大小可变数组的实现。实现了所有可选列表操作，
 * 并允许包括 null 在内的所有元素。除了实现 List 接口外，此类还提供一些方法来操作内部用来存储列表的数组的大小。
 * 特点：ArrayList中的元素和可以重复
 * 是有序的集合，长度不固定。
 * 不是线程安全的。
 * 	效率高。*/
public class A01ArrayList_不是线程安全_元素可以重复 {
    public static void main(String[] args) {
        /**创建ArrayList集合实现类*/
        List<String> listteacher1 = new ArrayList<>();
        /**集合中尾部添加元素*/
        listteacher1.add("奥迪");
        /**集合中指定索引处添加元素*/
        listteacher1.add(1,"宝马");
        listteacher1.add("玛莎拉蒂");
        /**创建ArrayList集合实现类*/
        List<String> listteacher2 = new ArrayList<>();
        listteacher2.add("黄鱼");
        listteacher2.add("老鸡");
        listteacher2.add("老鸭");
        listteacher2.add("老鸭");

        /**替换指定索引出的元素*/
        listteacher2.set(3,"元素");


        /**获取集合中指定索引的元素*/
        System.out.println("获取集合中指定索引的元素:"+listteacher1.get(0).toString());


        /**集合中添加另一个集合的元素*/
        listteacher1.addAll(listteacher2);
        System.out.println("集合中添加另一个集合的元素:" + listteacher1);

        /**清空集合*/
        //listteacher1.clear();

        /**删除集合中的元素,该元素后面的所有元素都会向前移动一步*/
        // listteacher1.remove("奥迪");//通过元素删除
        // listteacher1.remove(2);//通过索引删除
        // listteacher1.removeAll(listteacher2);//删除集合中另一个集合的元素

        /**集合中是否包含指定元素。*/
        System.out.println("集合中是否包含指定元素:" + listteacher1.contains("宝马"));
        /**集合中是否包含指定集合。*/
        System.out.println("集合中是否包含指定集合:" + listteacher1.containsAll(listteacher2));

        /**返回此列表中指定元素第一次出现的索引，如果此列表不包含该元素，则返回 -1。*/
        System.out.println(" 返回此列表中指定元素第一次出现的索引，如果此列表不包含该元素，则返回 -1。"+listteacher1.indexOf("老鸡"));

        /**返回此列表中指定元素最后一次出现的索引，如果此列表不包含该元素，则返回 -1。。*/
        System.out.println("返回此列表中指定元素最后一次出现的索引，如果此列表不包含该元素，则返回 -1。:"+listteacher1.lastIndexOf(""));

        /**判断集合是否为空。*/
        System.out.println("判断集合是否为空:" + listteacher1.isEmpty());

        /**把集合转成数组*/
        Object[] objects = listteacher1.toArray();
        System.out.println("把集合转成数组:" + Arrays.toString(objects));


        /**创建ArrayList集合实现类*/
        List<Student> studentList = new ArrayList<>();

        /**集合添加对象*/
        studentList.add(new Student(1, "周先生", 18));
        studentList.add(new Student(2, "黄先生", 18));
        System.out.println(studentList);

        List<Object> objects1 = new ArrayList<>();
        /**集合中添加另一个集合的元素*/
        objects1.addAll(studentList);
        System.out.println("集合中添加另一个集合的元素:"+objects1);
        /**集合中添加另一个集合*/
        objects1.add(listteacher1);
        System.out.println("集合中添加另一个集合:"+objects1);
    }


}
