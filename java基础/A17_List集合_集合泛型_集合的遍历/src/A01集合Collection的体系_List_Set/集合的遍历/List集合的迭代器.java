package A01集合Collection的体系_List_Set.集合的遍历;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class List集合的迭代器 {
    public static void main(String[] args) {
        /**创建ArrayList集合实现类*/
        List<String> listteacher1 = new ArrayList<>();
        /**集合中添加元素*/
        listteacher1.add("奥迪");
        listteacher1.add("宝马");
        listteacher1.add("玛莎拉蒂");
        listteacher1.add("大众");
        listteacher1.add("本田");
        //迭代器iterator(listteacher1);
        迭代器listiterator(listteacher1);
    }

    public static void 迭代器iterator(List<String> list) {
        //我们使用ListIterator来迭代
        ListIterator listIterator = list.listIterator();
        while(listIterator.hasNext()){
            //获得迭代的元素
            String str = (String) listIterator.next();
            if("刘唐".equals(str)){
                //我们不能在一边遍历的时候一边操作集合，这样有多线程的并发问题
                //list.add("白胜");
                //迭代器可以给我们提供了一个add方法让我们避免并发问题，但是添加的时候本次遍历不生效
                listIterator.add("白胜");
            }
            System.out.println(str);

        }
        System.out.println(list);
        System.out.println("集合的长度:" + list.size());

    }

    public static void 迭代器listiterator(List<String> list) {
        System.out.println("集合的长度:" + list.size());

        /**获取迭代器对象,迭代器的指针是可以返着遍历的*/
        ListIterator<String> listIterator1 = list.listIterator();
        /**判断是否有下一个元素*/
        while (listIterator1.hasNext()) {
            /**iterator.next()获取元素   jdk10  添加和删除也出错*/
//            if ("奥迪".equals((String)listIterator1.next())) {
//                listIterator1.add("迭代器");
//            }
            System.out.println(listIterator1.next());

        }
        System.out.println("集合的长度:" + list.size());
        /**判断是否有下一个元素*/
        while (listIterator1.hasPrevious()) {
            /**iterator.next()获取元素*/
            System.out.println( listIterator1.previous());
            /**在迭代器遍历的时候不能添加和删除等.....会报异常*/

        }

    }


    public static void println(List<String> list) {
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

    }
}

