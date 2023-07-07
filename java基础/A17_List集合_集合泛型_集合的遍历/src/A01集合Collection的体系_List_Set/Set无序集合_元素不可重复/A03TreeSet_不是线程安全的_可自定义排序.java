package A01集合Collection的体系_List_Set.Set无序集合_元素不可重复;

import java.util.TreeSet;

/**
 * TreeSet可以支持自定义排序，如果TreeSet所存储的对象的类没有实现Comparable接口就会报错ClassCastException。
 * 所以我们如果想要使用TreeSet来对自定义的对象来排序必须实现Comparable接口。
 * 特点：
 1.元素唯一性
 2.可自定义排序的
 3.不允许null存在
 4.不是线程安全
 */
public class A03TreeSet_不是线程安全的_可自定义排序 {
    public static void main(String[] args) {
        String  s1="AB";
        String  s2="AC";
        /**字符串的比较(如果是整数说明s1=大，如果是负数s2大，如果是o相等)*/
        System.out.println(s1.compareTo(s2));

        /**自定义排序(对象要实现 Comparable接口 重写compareTo()方法)*/
        TreeSet<Person1> treeSet = new TreeSet<>();
        treeSet.add(new Person1(2,"周先生",18));
        treeSet.add(new Person1(1,"周先生",18));
        treeSet.add(new Person1(5,"周先生",6));
        treeSet.add(new Person1(7,"周先生",18));

        System.out.println(treeSet);

    }
}

class Person1 implements  Comparable<Person1>{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private  int id;
    private String name;
    private int age;



    @Override
    public int compareTo(Person1 o) {
        /**做ID的差*/
        int flag= this.id-o.id;
        if (flag==0){
            /**判断字符串大小*/
            flag=  this.name.compareTo(o.name);
        }
        return flag;
    }
}

