package A02_synchronized锁_lock锁;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class A02_Lock锁 {
    public static void main(String[] args) {

        Ticket1 ticket1 = new Ticket1();

        new Thread((()->{ticket1.sale(); })).start();
        new Thread((()->{ticket1.sale();})).start();
        new Thread((()->{ticket1.sale(); })).start();
        new Thread((()->{ticket1.sale(); })).start();
        new Thread((()->{ticket1.sale(); })).start();


    }
}
class Ticket1 {
    /**创建可重入锁**(默认是非公平)*/
    ReentrantLock reentrantLock = new ReentrantLock();
    private int number = 500;

    public  void sale() {
        while (true) {

            if (number > 0) {
               /**加锁*/
                reentrantLock.lock();

               // reentrantLock.tryLock();尝试获取锁
                System.out.println(new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss   SSS ").format(new Date()));
                try {


                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第:" + ( number--) + "张票" + "   剩余" + number + "张票");
                /**解锁*/
                reentrantLock.unlock();
            }else  {break;}

        }



    }


}