package A02_synchronized锁_lock锁;

import java.util.concurrent.TimeUnit;

public class A01_synchronized锁 {
    public static void main(String[] args) {
        /****创建资源类*/
        Ticket ticket = new Ticket();

        /**多个线程操作用一个资源类(并发)(函数式接口(接口只有一个方法的就叫函数式接口))*/
        /**使用lambda操作用一个资源类*/
        new Thread(()->{
            ticket.sale();

        },"A线程").start();

        new Thread(()->{
            ticket.sale();

        },"B线程").start();

        new Thread(()->{

            ticket.sale();
        },"C线程").start();





    }
}

class Ticket {
    private int number = 500;
    /**synchronized包装线程安全**/
    public synchronized void sale() {

        while (true) {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第:" + ( number--) + "张票" + "   剩余" + number + "张票");
            }else  {break;}
            try {
                /***/
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }


}