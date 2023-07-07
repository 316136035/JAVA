package A03_生产者和消费者的问题;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class A02_lock生产者和消费者的使用 {
    public static void main(String[] args) {

        Data1 date1 = new Data1();

        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    date1.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"A").start();

        }
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    date1.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"B").start();
        }


    }
}
class Data1{
    private int number=0;

    //等待必须用while 不用if 防止虚假唤醒
    //生产消费者业务代码流程其实就是1.等待2.通知
    /**创建可重入锁就是读写锁*/
    ReentrantLock reentrantLock = new ReentrantLock();
    /***获取同步监视器*/
    Condition condition = reentrantLock.newCondition();
    public void increment() throws InterruptedException {
        try {
            /***加锁*/
            reentrantLock.lock();
            while (number!=0){
                /**监视器等待*/
                condition .await();
            }
            number++;
            //通知其它线程我执行完了+1
            /**监视器通知*/
            condition .signalAll();
            System.out.println(Thread.currentThread().getName()+"=>"+number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            /**释放锁*/
            reentrantLock.unlock();
        }


    }
    //-1
    public synchronized void decrement() throws InterruptedException {
        try {
            /***加锁*/
            reentrantLock.lock();
            while (number==0){
                /**监视器等待*/
                condition .await();
            }
            number--;
            //通知其它线程我执行完了-1
            /**监视器通知*/
            condition .signalAll();
            System.out.println(Thread.currentThread().getName()+"=>"+number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            /**释放锁*/
            reentrantLock.unlock();
        }


    }

}