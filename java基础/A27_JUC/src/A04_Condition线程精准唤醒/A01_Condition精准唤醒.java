package A04_Condition线程精准唤醒;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * A线下执行完调用B
 * B线下执行完调用C
 * C线下执行完调用D
 */
public class A01_Condition精准唤醒 {
    public static void main(String[] args) {

        Data data = new Data();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.A();
            }
        },"A线程").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.B();
            }
        },"B线程").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.C();
            }
        },"C线程").start();


    }
}



class Data {
    /**创建可重入锁就是读写锁*/
    ReentrantLock reentrantLock = new ReentrantLock();
    /***获取同步监视器*/
    Condition conditionA = reentrantLock.newCondition();
    /***获取同步监视器*/
    Condition conditionB = reentrantLock.newCondition();
    /***获取同步监视器*/
    Condition conditionC = reentrantLock.newCondition();

    int number = 1;

    public void A() {
        try {
            /**加锁*/
            reentrantLock.lock();
            while (number != 1) {
                /**等待*/
                conditionA.await();
            }
            System.out.println("我是A线程");
            number = 2;
            /**精准唤醒(B线程)*/
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**解锁*/
            reentrantLock.unlock();
        }


    }

    public void B() {
        try {

            reentrantLock.lock();
            while (number != 2) {
                conditionB.await();
            }
            System.out.println("我是B线程");
            number = 3;
            conditionC.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void C() {
        try {

            reentrantLock.lock();
            while (number != 3) {
                conditionC.await();
            }
            System.out.println("我是C线程");
            number = 1;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


}