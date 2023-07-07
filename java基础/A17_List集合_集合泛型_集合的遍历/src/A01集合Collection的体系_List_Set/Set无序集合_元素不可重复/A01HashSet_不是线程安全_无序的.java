package A01集合Collection的体系_List_Set.Set无序集合_元素不可重复;


import java.util.HashSet;
import java.util.Iterator;

/**
 * 特点：
 * 1.元素唯一性
 * 2.无序行
 * 3.允许null存在一个
 * 4.不是线程安全（效率高）
 */
public class A01HashSet_不是线程安全_无序的 {
    public static void main(String[] args) {


        HashSet<Person> hashSet = new HashSet<>();

        Person person1 = new Person("周先生", 18);
        Person person2 = new Person("黄先生", 18);
        Person person3 = new Person("黄先生", 18);

        /**如果指定的元素不存在，则将其添加到此集合中。
         * 我们可以重写他的equals方法来区别相同的对象
         * 注意：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码*/
        hashSet.add(person1);
        hashSet.add(person2);
        hashSet.add(person3);
        hashSet.add(person3);

        /**从此集合中删除所有元素。*/
        // hashSet.clear();
        /**返回true此集合是否包含指定元素。*/
        hashSet.contains("contains");
        /**true如果此集合不包含任何元素，则返回。*/
        hashSet.isEmpty();
        /**返回此集合中元素的迭代器。*/
        Iterator iterator = hashSet.iterator();
        /**如果存在，则从此集合中移除指定元素。*/
        hashSet.remove("B");

        System.out.println(hashSet);


    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 重写父类hashCode方法
     */
    @Override
    public int hashCode() {
        return 1;
    }

    /**
     * 重写父类equals方法
     */
    @Override
    public boolean equals(Object obj) {

        /**定义一个返回值*/
        boolean isEq = false;

        /**判断对象是否是Person对象*/
        if (obj instanceof Person) {
            /**强转*/
            Person p = (Person) obj;
            /**判断集合中对象的字符串和添加对象的字符串是否相等*/
           if (this.name!=null&&p.name!=null&&this.name.equals(p.name)&&this.age==p.age){
                /**ture代表相等*/
               isEq = true;
           }
        }
        return isEq;
    }

}

