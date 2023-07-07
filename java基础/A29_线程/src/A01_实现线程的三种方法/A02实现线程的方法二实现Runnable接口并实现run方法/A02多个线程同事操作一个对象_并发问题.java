package A01_实现线程的三种方法.A02实现线程的方法二实现Runnable接口并实现run方法;

import java.util.concurrent.TimeUnit;

public class A02多个线程同事操作一个对象_并发问题 {
    public static void main(String[] args) {
        /**多个线程同事操作一个对象_并发问题 请看锁的讲解*/
        RunnableText1 runnableText1 = new RunnableText1();
        new Thread( runnableText1).start();
        new Thread( runnableText1).start();
        new Thread( runnableText1).start();
        new Thread( runnableText1).start();

    }
}
class RunnableText1 implements  Runnable{
    /**定义一个票数*/
private int ticketNums=100;
    @Override
    public void run() {
        while (true){
            /**定义跳出循环体*/
            if (ticketNums<=0){break;}
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**获取线程名称*/
            System.out.println(Thread.currentThread().getName()+"购买:"+ ticketNums-- +"张票");

        }


    }
}
