package A09_ReentrantReadWriteLock读写锁;


import java.util.LinkedList;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 读--读 可以共存
 * 读==写 不可以共存
 * 写==写 不可以共存
 * */
public class A01_ReentrantReadWriteLock读写锁 {
    public static void main(String[] args) throws InterruptedException {
        MyLinkedList myLinkedList = new MyLinkedList();

        for (int i = 0; i < 1000; i++) {

            int finalI = i;
            new Thread(() -> {
                myLinkedList.addFirst(String.valueOf(finalI));
            }).start();
            TimeUnit.MILLISECONDS.sleep(1);
        }

        for (int i = 0; i < 1000; i++) {

            int finalI = i;
            new Thread(() -> {
                myLinkedList.removeLast();
            }).start();
        }






    }
}


/**自定义缓存区*/
class MyLinkedList {
    /**创建链表结构的集合*/
    volatile LinkedList<String> linkedList = new LinkedList<>();
    /**创建读写锁*/
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**添加方法*/
    public void addFirst(String str) {
        try {
            /**加锁*/
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + ":" + str + "写入中...");
            linkedList.addFirst(str);
            System.out.println(Thread.currentThread().getName() + ":" + str + "写入成功...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**解锁锁*/
            readWriteLock.writeLock().unlock();

        }

    }
    /**读取方法*/
    public void removeLast() {

        try {
            /**加锁*/
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + ":" + linkedList.getFirst() + "读取成功...");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            /**解锁锁*/
                readWriteLock.readLock().unlock();



        }

    }


}
