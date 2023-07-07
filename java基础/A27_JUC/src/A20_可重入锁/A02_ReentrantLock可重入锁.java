package A20_可重入锁;

import java.util.concurrent.locks.ReentrantLock;

public class A02_ReentrantLock可重入锁 {
    public static void main(String[] args) {
        Phone1 phone1 = new Phone1();
        new Thread(() -> {
            phone1.sms();
        }, "线程1").start();
        new Thread(() -> {
            phone1.sms();
        }, "线程2").start();


    }
}

class Phone1 {
    /**创建可重入锁   锁一定要配对*/
    ReentrantLock reentrantLock = new ReentrantLock();
    public  void sms() {

        try {
            /**第一把锁 加锁**/
            reentrantLock.lock();
            call();
            System.out.println("发短信");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**第一把锁解锁**/
            reentrantLock.unlock();
        }

    }

    public void call() {
        try {
            /**第二把锁 加锁**/
            reentrantLock.lock();
            System.out.println("打电话");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**第二把锁解锁**/
            reentrantLock.unlock();
        }





    }


}