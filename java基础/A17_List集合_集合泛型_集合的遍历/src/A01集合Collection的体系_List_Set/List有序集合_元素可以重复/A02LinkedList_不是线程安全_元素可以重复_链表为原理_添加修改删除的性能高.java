package A01集合Collection的体系_List_Set.List有序集合_元素可以重复;

import java.util.LinkedList;

/**
 * List 接口的链接列表实现。
 * 实现所有可选的列表操作，并且允许所有元素（包括 null）。
 * 特点：LinkedList中的元素和可以重复
 * 除了实现 List 接口外，LinkedList 类还为在列表的开头及结尾 get、remove 和 insert 元素提供了统一的命名方法。
 * 这些操作允许将链接列表用作堆栈、队列或双端队列。
 * 不是线程安全的。
 * <p>
 * LinkedList是链表为原理，添加修改删除的性能高。
 */
public class A02LinkedList_不是线程安全_元素可以重复_链表为原理_添加修改删除的性能高 {
    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        /**将指定的元素附加到此列表的末尾。*/
        linkedList.add("末尾添加");
        /**在此列表中的指定位置插入指定元素。*/
        linkedList.add(0, "插入指定元素");
        /**在此列表的开头插入指定的元素。*/
        linkedList.addFirst("开头插入指定的元素");
        /**将指定的元素附加到此列表的末尾。*/
        linkedList.addLast("末尾插入指定的元素");
        /**从此列表中删除所有元素*/
        //linkedList.clear();
        /**返回true此列表是否包含指定元素。*/
        linkedList.contains("末尾添加");
        /**返回第一个元素。*/
        linkedList.element();
        /**返回指定元素。*/
        System.out.println(linkedList.get(2).toString());
        /**返回此列表中的第一个元素。()*/
        linkedList.getFirst();
        /**返回此列表中的最后一个元素。。()*/
        linkedList.getLast();
        /**返回此列表中指定元素第一次出现的索引，如果此列表不包含该元素，则返回 -1。*/
        linkedList.indexOf("末尾添加");
        /**返回此列表中指定元素最后一次出现的索引，如果此列表不包含该元素，则返回 -1。*/
        linkedList.lastIndexOf("末尾添加");

        /**检索并删除此列表的头部（第一个元素）。*/
        // linkedList.remove();
        /**检索并删除指定元素。*/
        // linkedList.remove(0);
        /**从此列表中移除并返回第一个元素。*/
        // linkedList.removeFirst();
        /**从此列表中移除并返回最后一个元素。*/
        //linkedList.removeLast();


        System.out.println(linkedList);
        /**出栈  移除第一个参数*/
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        /**压栈  添加第一个参数*/
        linkedList.push("压栈");


        /**其他请看API*/



    }


}
