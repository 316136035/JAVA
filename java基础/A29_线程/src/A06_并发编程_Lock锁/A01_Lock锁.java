package A06_并发编程_Lock锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class A01_Lock锁 {
    public static void main(String[] args) {
        /**定义一个Runnable对象，线程共享*/
        LocKText locKText = new LocKText();
        /**开启线程*/
        new  Thread(locKText).start();
        /**开启线程*/
        new  Thread(locKText).start();
        /**开启线程*/
        new  Thread(locKText).start();
        /**开启线程*/
        new  Thread(locKText).start();




    }
}
class LocKText  implements  Runnable{

    /**定义一个 ReentrantLock锁*/
  private  final ReentrantLock reentrantLock = new ReentrantLock();
    Integer integer=100;
    Boolean falg=true;
    /**线程实现类*/
    @Override
    public void run() {
        while (falg){
            /**加锁*/
            reentrantLock.lock();

            try {
                /**工作代码*/
                work();
            }finally {
                /**解锁*/
                reentrantLock.unlock();
            }


            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    /**工作代码*/
    private void work() {

        if (integer!=null&&integer>0){

            System.out.println(Thread.currentThread().getName()+"   "+integer--);
        }else {
            falg=false;
        }

    }
}