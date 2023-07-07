package A04_并发_多个线程使用同一个资源不安全;

import java.util.concurrent.TimeUnit;

public class A01线程并发不安全_卖火车票案例_synchronized解决 {
    public static void main(String[] args) {

        /**创建实现了 Runnable的对象*/
        BuyTicket buyTicket = new BuyTicket();
        /**创建线程并开启线程/*/
        new Thread(buyTicket).start();
        /**创建线程并开启线程/*/
        new Thread(buyTicket).start();
        /**创建线程并开启线程/*/
        new Thread(buyTicket).start();

    }
}
class BuyTicket  implements  Runnable{
    /**定义票数*/
    private   int  tichetNums=100;
    /**定义标志位*/
    boolean flag =true;
    @Override
    public void run() {
        /**循环条件是否有票**/
        while (flag){
            /**模拟延迟*/
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**购票的方法*/
            buy();
        }
    }
    /**购票的方法  synchronized默认锁的是this 所以可以锁这个方法*/
    private synchronized void  buy(){
        /**判断是否有票*/
       if (tichetNums>0){
           System.out.println(Thread.currentThread().getName()+"买票成功"+tichetNums--);
       }else {
           /**没有票就停止线程*/flag=false;
       }


    }
}