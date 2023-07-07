package A03_线程的方法;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep(时间)指定当前线程阻塞的毫秒数;
 * sleep存在异常InterruptedException;
 * sleep时间达到后线程进入就绪状态;
 * sleep可以模拟网络延时，倒计时等。
 * 每一个对象都有一个锁，sleep不会释放锁;*/
public class A02线程的休眠sleep {
    public static void main(String[] args) {

        /**创建线程并执行*/
        new Thread(new SleepText()).start();

        /**创建线程并执行*/
        new Thread(new SleepText()).start();


    }
}

/**
 * 实现Runnable的方法创建线程
 */
class SleepText implements Runnable {
    /**
     * 线程执行体
     */
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            Date date = new Date(System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() +"  "+
                    new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss----SSS ").format(date) + "   " + i);
            try {
                /**线程的休眠(毫秒)  放大线程的发生性(每一个对象都有一个锁,sleep不会释放锁;)**/
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (i >= 10) {
                break;
            }
        }
    }
}