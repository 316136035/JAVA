package A21_自旋锁_死锁.A01_自旋锁;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class A01_自旋锁 {
    public static void main(String[] args) {

        MyLock myLock = new MyLock();

        new Thread(()->{
            try {
                myLock.Lock();


                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unLock();

            }


        },"线程 A").start();

        new Thread(()->{
            try {
                myLock.Lock();


                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unLock();

            }


        },"线程 B").start();



    }

}
class MyLock{

    /**创建AtomicReferenc期望值对象*/
    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();

    public void Lock() {
        /**获取线程当前状态*/
        Thread thread = Thread.currentThread();

        /**AtomicReferenc期望值是null 设置为thread对象地址*/
        while (threadAtomicReference.compareAndSet(null,thread)){

        }

    }
    public void unLock() {
        /**获取线程当前状态*/
        Thread thread = Thread.currentThread();
        /**AtomicReferenc期望值thread对象地址  设置为null*/
        threadAtomicReference.compareAndSet(thread,null);



    }











}