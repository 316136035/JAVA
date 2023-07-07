package A08_计数器_信号量;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class A02_CyclicBarrier加法计数器 {
    public static void main(String[] args) throws InterruptedException {

        /**加法计数器(线程执行次数,Runnable)*/
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{
            System.out.println("成功...");
        });

        for (int i = 1; i <= 15; i++) {
            TimeUnit.SECONDS.sleep(1);

           int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+":"+ finalI);
                try {
                    /**等待线程执行次数后调用Runnable的方法*/
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
