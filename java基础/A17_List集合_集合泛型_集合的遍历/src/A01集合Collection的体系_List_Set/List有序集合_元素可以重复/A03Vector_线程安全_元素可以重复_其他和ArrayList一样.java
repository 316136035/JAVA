package A01集合Collection的体系_List_Set.List有序集合_元素可以重复;

import java.util.Enumeration;
import java.util.Vector;


/***ArrayList功能类似，最主要的区别就在于vector是线程并发安全的。但是缺点是效率比较低。
 */
public class A03Vector_线程安全_元素可以重复_其他和ArrayList一样 {
    public static void main(String[] args) {
        Vector<Object> vector = new Vector<>();
        vector.add("黄鱼");
        vector.add("老鸡");
        vector.add("老鸭");
        vector.add("老鸭");

        /**获取枚举对象*/
        Enumeration<Object> elements = vector.elements();
        /**获取是否有下一个参数*/
        while ( elements.hasMoreElements()){
            /**获取每一个参数*/
            System.out.println( elements.nextElement());
        }

    }
}
